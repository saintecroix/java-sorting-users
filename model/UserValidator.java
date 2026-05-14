package model;

public class UserValidator {
    public void validatePassword(int password) throws ValidationException {
        if(password < 8){
            throw new ValidationException("password", "слишком короткий");
        }
    }
    public void validateName(String name) throws ValidationException {
        if(name.length() < 2 || name.length() > 50){
            throw new ValidationException("name", "слишком короткое имя или слишком длинное имя ");
        }
        if (!name.matches("[a-zA-Zа-яА-ЯёЁ0-9]+")){
            throw new ValidationException("name", " 2-50 символов, только буквы и цифры ");
        }
    }
    public void validateEmail(String email) throws ValidationException {
        if (!email.matches("[^@]+@[^@]+\\.[^@]+")){
            throw new ValidationException("email", "Почта неправильная ");
        }
    }
}
