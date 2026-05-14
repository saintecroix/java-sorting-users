package test;

import model.User;
import sorting.NameSortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class NameSortingStrategyTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(User.builder().name("Дмитрий").build());
        users.add(User.builder().name("Андрей").build());
        users.add(User.builder().name("Кирилл").build());

        NameSortingStrategy nameSortingStrategy = new NameSortingStrategy();
        nameSortingStrategy.sort(users);

        for (User user : users) {
            System.out.println(user.getName());
        }
        if (users.get(0).getName().equals("Андрей")){
            System.out.println("Успешно");
        } else {
            System.out.println("Не работает");
        }
    }
}
