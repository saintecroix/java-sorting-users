package test;

import model.UserValidator;
import model.ValidationException;

public class UserValidatorTest {
    public static void main(String[] args) {
        try {
            new UserValidator().validatePassword("123");
            System.out.println("Не работает");
        } catch (ValidationException e) {
            System.out.println("Успешно");
        }

        try {
            new UserValidator().validateName("n");
            System.out.println("Не работает");
        } catch (ValidationException e) {
            System.out.println("Успешно");
        }

        try {
            new UserValidator().validateEmail("rrrw2mail.ru");
            System.out.println("Не работает");
        } catch (ValidationException e) {
            System.out.println("Успешно");
        }
    }

}
