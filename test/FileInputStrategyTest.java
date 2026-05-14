package test;
import input.FileInputStrategy;
import model.User;

import java.util.List;

public class FileInputStrategyTest {
    public static void main(String[] args) {
        FileInputStrategy fileInputStrategy = new FileInputStrategy("test_users.csv");

        List<User> users = fileInputStrategy.generate(3);

        if (users.size() == 3) {
            System.out.println("Успешно");
        } else {
            System.out.println("Не работает");
        }

        try {
            new FileInputStrategy("test_users.csv").generate(0);
            System.out.println("Не работает");
        } catch (IllegalArgumentException e) {
            System.out.println("Успешно");
        }
    }
}

