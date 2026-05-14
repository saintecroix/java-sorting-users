package output;

import model.User;
import java.util.List;

public interface OutputStrategy {
    
        void save(List<User> users, String filePath);
}