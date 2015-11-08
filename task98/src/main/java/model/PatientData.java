package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vlad on 27.10.15.
 */
@Entity
@Table(name = "patient_data")
public class PatientData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date visit_date;

    private int cost;

    @OneToOne
    @JoinColumn(name = "people_id")
    private People people;

    public PatientData() {
    }

    public PatientData(Date visit_date, int cost, People people) {
        this.visit_date = visit_date;
        this.cost = cost;
        this.people = people;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
