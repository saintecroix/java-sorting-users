package input;
import sorting.SortingStrategy;
import java.util.Comparator;
import java.util.List;

public class NameSortingStrategy implements SortingStrategy {
    public void sort(List<User> users) {
        users.sort(Comparator.comparing(user -> user.getName()));
    }
}
