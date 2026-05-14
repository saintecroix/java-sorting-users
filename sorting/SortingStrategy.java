package sorting;
import java.util.List;
import model.User;

public interface SortingStrategy {
        void sort(List<User> users);
}