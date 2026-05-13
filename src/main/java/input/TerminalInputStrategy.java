package input;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalInputStrategy implements InputStrategy {
    private final Scanner scanner;
    private static int nextId = 1;

    public TerminalInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<User> generate(int size) {
        if (size <= 0) throw new IllegalArgumentException("size > 0");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("\n--- Пользователь " + (i + 1) + " ---");
            users.add(readUser());
        }
        return users;
    }

    private User readUser() {
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        return User.builder()
                .id(nextId++)
                .name(name)
                .password(password)
                .email(email)
                .build();
    }
}

