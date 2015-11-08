package form;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserRegistrationForm {

    @NotEmpty(message = "Логин не может быть пустым")
    private String login;

    @NotEmpty(message = "Имя не может быть пустым")
    private String name;

    @NotEmpty(message = "Фамилия не может быть пустой")
    private String surname;

    @Size(min = 6, max = 24, message = "Пароль неверной длины")
    private String password;

    private String repassword;

    @NotEmpty
    private String city;

    @NotEmpty
    @Email(message = "Невалидный email")
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
