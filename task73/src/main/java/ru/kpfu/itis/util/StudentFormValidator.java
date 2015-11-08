














package ru.kpfu.itis.util;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Student user = (Student) o;

        Pattern fio = Pattern.compile("[A-za-z]+");

        if (user.getName() == null || user.getName().isEmpty()) {
            errors.rejectValue("name", "", "Заполните поле");
        } else {
            Matcher m = fio.matcher(user.getName());
            if (!m.matches()) {
                errors.rejectValue("name", "", "Поле заполнено неверно");
            }
        }

        if (user.getSurname() == null || user.getSurname().isEmpty()) {
            errors.rejectValue("surname", "", "Заполните поле");
        } else {
            Matcher m = fio.matcher(user.getSurname());
            if (!m.matches()) {
                errors.rejectValue("surname", "", "Поле заполнено неверно");
            }
        }

        if (user.getLastname() == null || user.getLastname().isEmpty()) {
            errors.rejectValue("lastname", "", "Заполните поле");
        } else {
            Matcher m = fio.matcher(user.getLastname());
            if (!m.matches()) {
                errors.rejectValue("lastname", "", "Поле заполнено неверно");
            }
        }

        if (user.getGroup() == null || user.getGroup().isEmpty()) {
            errors.rejectValue("group", "", "Заполните поле");
        } else {
            Matcher m = Pattern.compile("[\\d-]+").matcher(user.getGroup());
            if (!m.matches()) {
                errors.rejectValue("group", "", "Неверная группа");
            }
        }

    }
}
