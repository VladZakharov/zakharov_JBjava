package model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by vlad on 27.10.15.
 */

@Entity
@Table(name = "jur_info")
public class JuridicalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String series;

    private String number;

    @Column(nullable = false)
    private UUID unic_number_uuid;

    public JuridicalInfo() {
        unic_number_uuid = UUID.randomUUID();
    }

    public JuridicalInfo(String series, String number) {
        this.series = series;
        this.number = number;
        unic_number_uuid = UUID.randomUUID();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getUnic_number_uuid() {
        return unic_number_uuid;
    }

}
