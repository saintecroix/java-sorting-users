package sorting;
import java.util.Comparator;
import java.util.List;
import model.User;

public class NameSortingStrategy implements SortingStrategy {
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(user -> user.getName()));
    }
}

