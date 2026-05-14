package sorting;
import model.User;
import java.util.Comparator;
import java.util.List;

public class EmailSortStrategy implements SortingStrategy {
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(user -> user.getEmail()));
    }
}
