package fr.givemeacar.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bills", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bill  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "date", nullable = false)
    private Date date;
    @OneToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "id",
            nullable = false, updatable = false,insertable = false)
    private Rent rent;
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id",
            nullable = false, updatable = false,insertable = false)
    private Agency agency;
    @Column(name = "rent_id", nullable = false)
    private int rent_id;
    @Column(name = "agency_id", nullable = false)
    private int agency_id;

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public int getRent_id() {
        return rent_id;
    }

    public void setRent_id(int rent_id) {
        this.rent_id = rent_id;
    }

    public int getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(int agency_id) {
        this.agency_id = agency_id;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill bill = (Bill) o;
        return Double.compare(bill.price, price) == 0 &&
                rent_id == bill.rent_id &&
                agency_id == bill.agency_id &&
                Objects.equals(getId(), bill.getId()) &&
                Objects.equals(date, bill.date) &&
                Objects.equals(rent, bill.rent) &&
                Objects.equals(agency, bill.agency);
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), price, date, rent, agency, rent_id, agency_id);
    }


}
