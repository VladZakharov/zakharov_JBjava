package model;

import model.enums.PeopleType;

import javax.persistence.*;

/**
 * Created by vlad on 27.10.15.
 */

@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String fio;

    @Column(nullable = false)
    private String pasport_series;

    @Column(nullable = false)
    private String pasport_number;

    @Column(nullable = false)
    private String pasport_issued;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PeopleType type;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public People() {
    }

    public People(String fio, String pasport_series, String pasport_number, String pasport_issued, PeopleType type, Office office) {
        this.fio = fio;
        this.pasport_series = pasport_series;
        this.pasport_number = pasport_number;
        this.pasport_issued = pasport_issued;
        this.type = type;
        this.office = office;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPasport_series() {
        return pasport_series;
    }

    public void setPasport_series(String pasport_series) {
        this.pasport_series = pasport_series;
    }

    public String getPasport_number() {
        return pasport_number;
    }

    public void setPasport_number(String pasport_number) {
        this.pasport_number = pasport_number;
    }

    public String getPasport_issued() {
        return pasport_issued;
    }

    public void setPasport_issued(String pasport_issued) {
        this.pasport_issued = pasport_issued;
    }

    public PeopleType getType() {
        return type;
    }

    public void setType(PeopleType type) {
        this.type = type;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
