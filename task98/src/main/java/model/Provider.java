package model;

import javax.persistence.*;

/**
 * Created by vlad on 27.10.15.
 */
@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "jur_info")
    private JuridicalInfo juridicalInfo;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public Provider() {
    }

    public Provider(String name, JuridicalInfo juridicalInfo, Office office) {
        this.name = name;
        this.juridicalInfo = juridicalInfo;
        this.office = office;
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

    public JuridicalInfo getJuridicalInfo() {
        return juridicalInfo;
    }

    public void setJuridicalInfo(JuridicalInfo juridicalInfo) {
        this.juridicalInfo = juridicalInfo;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
