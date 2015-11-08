package service;

import form.UserRegistrationForm;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveNewUser(UserRegistrationForm form);

    User getUser(Long id);

    User getUser(String login);

    User updateUser(User user);

    List<User> getAll();
}
