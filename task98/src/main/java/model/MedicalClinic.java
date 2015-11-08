package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vlad on 27.10.15.
 */
@Entity
@Table(name = "med_clinic")
public class MedicalClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creating_date;

    @Column(nullable = false)
    private int license_number;

    public MedicalClinic() {
    }

    public MedicalClinic(String name, Date creating_date, int license_number) {
        this.name = name;
        this.creating_date = creating_date;
        this.license_number = license_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreating_date() {
        return creating_date;
    }

    public void setCreating_date(Date creating_date) {
        this.creating_date = creating_date;
    }

    public int getLicense_number() {
        return license_number;
    }

    public void setLicense_number(int license_number) {
        this.license_number = license_number;
    }

}
