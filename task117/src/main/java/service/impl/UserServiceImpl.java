package service.impl;

import form.UserRegistrationForm;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;
import util.UserRegistrationFormToUserTransformer;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public void saveNewUser(UserRegistrationForm form) {
        User user = UserRegistrationFormToUserTransformer.transform(form);
        repository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return repository.findOneById(id);
    }

    @Override
    public User getUser(String login) {
        return repository.findOneByLogin(login);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

}
