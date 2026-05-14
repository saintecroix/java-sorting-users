package input;

import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileInputStrategy implements InputStrategy {
    private final String filePath;
    private static int nextId = 1;

    public FileInputStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<User> generate(int size) {
        if (size <= 0) throw new IllegalArgumentException("size > 0");
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .limit(size)
                    .map(this::parseUser)
                    .filter(user -> user != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return List.of();
        }
    }

    private User parseUser(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            System.err.println("Пропущена строка (не 3 поля): " + line);
            return null;
        }
        try {
            String name = parts[0].trim();
            String password = parts[1].trim();
            String email = parts[2].trim();
            return User.builder()
                    .id(nextId++)
                    .name(name)
                    .password(password)
                    .email(email)
                    .build();
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка валидации в строке: " + line);
            return null;
        }
    }
}