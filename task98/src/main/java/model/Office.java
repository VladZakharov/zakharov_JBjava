package model;

import javax.persistence.*;

/**
 * Created by vlad on 27.10.15.
 */
@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "medClinic_id")
    private MedicalClinic medicalClinic;

    private String street;

    public Office() {
    }

    public Office(String city, MedicalClinic medicalClinic, String street) {
        this.city = city;
        this.medicalClinic = medicalClinic;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public MedicalClinic getMedicalClinic() {
        return medicalClinic;
    }

    public void setMedicalClinic(MedicalClinic medicalClinic) {
        this.medicalClinic = medicalClinic;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
