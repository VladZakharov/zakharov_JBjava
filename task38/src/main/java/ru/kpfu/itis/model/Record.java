package ru.kpfu.itis.model;

/**
 * Created by vlad on 11.10.15.
 */
public class Record {

    private String name;

    private String surname;

    private String midname;

    private String birthday;

    private String sex;

    public Record() {
    }

    public Record(String name, String surname, String midname, String birthday, String sex) {

        this.name = name;
        this.surname = surname;
        this.midname = midname;
        this.birthday = birthday;
        this.sex = sex;
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

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
