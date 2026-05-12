package input;

import model.User;

import java.util.List;

public interface InputStrategy {
    List<User> generate(int size);
}
