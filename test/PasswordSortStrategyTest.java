package test;
import model.User;
import sorting.PasswordSortStrategy;

import java.util.ArrayList;
import java.util.List;

public class PasswordSortStrategyTest {
        public static void main(String[] args) {
            List<User> users = new ArrayList<>();
            users.add(User.builder().password("pass").build());
            users.add(User.builder().password("password123").build());
            users.add(User.builder().password("qwerty").build());

            PasswordSortStrategy passwordSortStrategy = new PasswordSortStrategy();
            passwordSortStrategy.sort(users);

            for (User user : users) {
                System.out.println(user.getPasswordLength());
            }
            if (users.get(0).getPasswordLength() == 4) {
                System.out.println("Успешно");
            } else {
                System.out.println("Не работает");
            }
        }
    }
