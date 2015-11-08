package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vlad on 27.10.15.
 */
@Entity
@Table(name = "stuff_data")
public class StuffData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date employent_date;

    private Date creatin_date;

    @Column(nullable = false)
    private int expected_time;

    @Column(nullable = false)
    private int salary;

    @OneToOne
    @JoinColumn(name = "people_id")
    private People people;

    public StuffData() {
    }

    public StuffData(Date employent_date, Date creatin_date, int expected_time, int salary, People people) {
        this.employent_date = employent_date;
        this.creatin_date = creatin_date;
        this.expected_time = expected_time;
        this.salary = salary;
        this.people = people;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEmployent_date() {
        return employent_date;
    }

    public void setEmployent_date(Date employent_date) {
        this.employent_date = employent_date;
    }

    public Date getCreatin_date() {
        return creatin_date;
    }

    public void setCreatin_date(Date creating_date) {
        this.creatin_date = creating_date;
    }

    public int getExpected_time() {
        return expected_time;
    }

    public void setExpected_time(int expected_time) {
        this.expected_time = expected_time;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public int getWorked_hours() {
        Date end = new Date();
        if (creatin_date != null) {
            end = creatin_date;
        }
        return (int) ((end.getTime() - employent_date.getTime()) / (1000*60*60*24*7)) * expected_time;
    }
}
