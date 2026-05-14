package sorting;
import java.util.Comparator;
import java.util.List;
import model.User;

public class PasswordSortStrategy implements SortingStrategy {
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(user -> user.getPasswordLength()));
    }
}