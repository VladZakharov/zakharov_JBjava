package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Record;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vlad on 10.10.15.
 */
public class RecordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Record.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Record record = (Record) o;
        if (record.getName() == null || record.getName().isEmpty()) {
            errors.rejectValue("name", "", getWarning());
        }
        if (record.getSurname() == null || record.getSurname().isEmpty()) {
            errors.rejectValue("surname", "", getWarning());
        }
        if (record.getMidname() == null || record.getMidname().isEmpty()) {
            errors.rejectValue("midname", "", getWarning());
        }

        Pattern p = Pattern.compile("(0?\\d|[12]\\d|3[01])[-/.](0?\\d|1|1[012])[-/.](\\d\\d)?\\d\\d");
        Matcher m = p.matcher(record.getBirthday());
        if (!m.matches()) {
            errors.rejectValue("birthday", "", "Not a correct date (ex. 1.07.2002)");
        }

        p = Pattern.compile("(male)|(female)|(m)|(f)|()");
        m = p.matcher(record.getSex());
        if (!m.matches()) {
            errors.rejectValue("sex", "", "Your sex is " + record.getSex() + "??? Realy? Try something like 'male' or 'female'.");
        }
    }

    private String getWarning() {
        int c = (int) (Math.random() * 4);
        switch (c) {
            case 0:
                return "Hey, man. Type here something";
            case 1:
                return "Well... But fill this field, please.";
            case 2:
                return "Can you guess yourself what's wrong?...";
            case 3:
                return "It's so empty in field at left... Try again ;)";
            default:
                return "Man. Your stupidity makes me cry.";
        }
    }

}
