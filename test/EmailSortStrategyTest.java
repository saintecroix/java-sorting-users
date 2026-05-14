package test;

import model.User;
import sorting.EmailSortStrategy;

import java.util.ArrayList;
import java.util.List;

public class EmailSortStrategyTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(User.builder().email("dmitry@mail.ru").build());
        users.add(User.builder().email("andrey@gmail.com").build());
        users.add(User.builder().email("kirill@yandex.ru").build());

        EmailSortStrategy emailSortStrategy = new EmailSortStrategy();
        emailSortStrategy.sort(users);

        for (User user : users) {
            System.out.println(user.getEmail());
        }
        if (users.get(0).getEmail().equals("andrey@gmail.com")) {
            System.out.println("Успешно");
        } else {
            System.out.println("Не работает");
        }
    }
}