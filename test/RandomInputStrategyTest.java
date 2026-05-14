package test;

import input.RandomInputStrategy;
import model.User;
import model.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class RandomInputStrategyTest {
    public static void main(String[] args) {
        RandomInputStrategy randomInputStrategy = new RandomInputStrategy();

        List<User> users = randomInputStrategy.generate(3);

        if (users.size() == 3) {
            System.out.println("Успешно");
        } else {
            System.out.println("Не работает");
        }

        try {
            new RandomInputStrategy().generate(0);
            System.out.println("Не работает");
        } catch (IllegalArgumentException e) {
            System.out.println("Успешно");
        }
    }
}
