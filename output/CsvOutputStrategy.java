package output;

import model.User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvOutputStrategy implements OutputStrategy {
    
    @Override
    public void save(List<User> users, String filePath) {
               if (users == null || users.isEmpty()) {
            System.out.println("Нет пользователей для сохранения");
            return;
        }
        
               boolean fileExists = new File(filePath).exists();
        
                try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
                        if (!fileExists || new File(filePath).length() == 0) {
                pw.println("name,passwordLength,email");
            }
            
                        for (User user : users) {
                String line = convertToCsvLine(user);
                pw.println(line);
            }
            
            System.out.println("Сохранено " + users.size() + " пользователей в файл: " + filePath);
            
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    
        private String convertToCsvLine(User user) {
               String name = user.getName() != null ? user.getName() : "";
        String email = user.getEmail() != null ? user.getEmail() : "";
        int passwordLength = user.getPasswordLength();
        
                name = name.contains(",") ? "\"" + name + "\"" : name;
        email = email.contains(",") ? "\"" + email + "\"" : email;
        
        return name + "," + passwordLength + "," + email;
    }
}