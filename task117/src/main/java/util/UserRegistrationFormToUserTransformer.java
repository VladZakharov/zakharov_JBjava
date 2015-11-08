package util;


import form.UserRegistrationForm;
import model.User;
import model.enums.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRegistrationFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        User user = new User();
        user.setLogin(form.getLogin());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setRole(UserRole.ROLE_USER);
        user.setPassword(encoder.encode(form.getPassword()));
        user.setCity(form.getCity());
        return user;
    }
}
