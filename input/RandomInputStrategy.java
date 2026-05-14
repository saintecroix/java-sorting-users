package input;


import model.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomInputStrategy implements InputStrategy {
    private final Random random = new Random();
    private final String[] names = {"Анна", "Иван", "Мария", "Петр", "Елена", "Алексей", "Ольга", "Дмитрий"};
    private final String[] domains = {"mail.ru", "yandex.ru", "gmail.com", "outlook.com"};
    private static int nextId = 1;

    @Override
    public List<User> generate(int size) {
        if (size <= 0) throw new IllegalArgumentException("size > 0");
        return IntStream.range(0, size)
                .mapToObj(i -> generateRandomUser())
                .collect(Collectors.toList());
    }

    private User generateRandomUser() {
        String name = names[random.nextInt(names.length)] + (random.nextInt(1000));
        String password = "pass" + random.nextInt(10000);
        String email = name.toLowerCase() + "@" + domains[random.nextInt(domains.length)];
        return User.builder()
                .id(nextId++)
                .name(name)
                .password(password)
                .email(email)
                .build();
    }
}