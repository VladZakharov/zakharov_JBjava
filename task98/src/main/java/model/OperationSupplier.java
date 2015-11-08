package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vlad on 27.10.15.
 */
@Entity
@Table(name = "operation_supplier")
public class OperationSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date begin_date;

    private Date end_date;

    @OneToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @Column(nullable = false)
    private int count;

    @OneToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public OperationSupplier() {
    }

    public OperationSupplier(Date begin_date, Date end_date, Office office, int count, Provider provider) {
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.office = office;
        this.count = count;
        this.provider = provider;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
