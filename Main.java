import model.User;
import output.CsvOutputStrategy;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User ivan = User.builder()
            .id(1)
            .name("Иван Иванов")
            .password("secret123")
            .email("ivan@mail.ru")
            .build();
        
        User petr = User.builder()
            .id(2)
            .name("Петр Петров")
            .password("pass456")
            .email("petr@mail.ru")
            .build();
        
        CsvOutputStrategy csvOutput = new CsvOutputStrategy();
        csvOutput.save(Arrays.asList(ivan, petr), "users.csv");
        
        System.out.println("Готово! Проверьте файл users.csv");
    }
}