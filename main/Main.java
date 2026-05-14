import input.FileInputStrategy;
import input.InputStrategy;
import input.RandomInputStrategy;
import input.TerminalInputStrategy;
import model.User;
import model.UserValidator;
import model.ValidationException;
import output.CsvOutputStrategy;
import output.OutputStrategy;
import sorting.EmailSortStrategy;
import sorting.NameSortingStrategy;
import sorting.PasswordSortStrategy;
import sorting.SortingStrategy;

void main() {
    Scanner scanner = new Scanner(System.in);

    IO.println("=== JAVA SORTING USERS DEMO ===\n");

    List<User> users = generateUsers(scanner);
    printUsers(users);

    SortingStrategy sorter = selectSortingStrategy(scanner);
    IO.println("\n--- Сортировка " + sorter.getClass().getSimpleName() + " ---");
    sorter.sort(users);
    printUsers(users);

    List<User> validUsers = validateUsers(users);
    saveUsers(validUsers, scanner);

    scanner.close();
}

private static List<User> generateUsers(Scanner scanner) {
    IO.print("Источник (1-File, 2-Random, 3-Terminal): ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    InputStrategy strategy = switch (choice) {
        case 1 -> new FileInputStrategy("users.csv");
        case 2 -> new RandomInputStrategy();
        case 3 -> new TerminalInputStrategy(scanner);
        default -> new RandomInputStrategy();
    };

    return strategy.generate(5);
}

private static SortingStrategy selectSortingStrategy(Scanner scanner) {
    IO.print("Сортировка (1-Name, 2-Email, 3-Password): ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    return switch (choice) {
        case 1 -> new NameSortingStrategy();
        case 2 -> new EmailSortStrategy();
        case 3 -> new PasswordSortStrategy();
        default -> new NameSortingStrategy();
    };
}

private static void printUsers(List<User> users) {
    users.forEach(u -> System.out.printf("  %s (len:%d) <%s>%n",
            u.getName(), u.getPasswordLength(), u.getEmail()));
}

private static List<User> validateUsers(List<User> users) {
    UserValidator validator = new UserValidator();
    List<User> validUsers = new ArrayList<>();

    IO.println("\n--- ✅ ВАЛИДАЦИЯ ---");
    for (User user : users) {
        try {
            validator.validateName(user.getName());
            validator.validatePassword(user.getPasswordLength());
            validator.validateEmail(user.getEmail());
            IO.println("  ✅ " + user.getName() + " — OK");
            validUsers.add(user);
        } catch (ValidationException e) {
            IO.println("  ❌ " + user.getName() + ": " + e.getMessage());
        }
    }

    IO.println(validUsers.size() == users.size()
            ? "🎉 Все пользователи валидны!"
            : "⚠️ Найдены ошибки валидации. Некоторые пользователи не будут сохранены.");

    return validUsers;
}

private static void saveUsers(List<User> users, Scanner scanner) {
    IO.print("Сохранить в users_output.csv? [y/n]: ");
    if (scanner.nextLine().toLowerCase().startsWith("y")) {
        OutputStrategy saver = new CsvOutputStrategy();
        saver.save(users, "users_output.csv");
        IO.println("✅ Сохранено в users_output.csv");
    }
}
