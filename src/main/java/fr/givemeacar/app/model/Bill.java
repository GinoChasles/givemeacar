package fr.givemeacar.app.model;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "bills", schema = "givemeacar", catalog = "")
public class Bill  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Column(name = "date", nullable = false)
    private Date date;
    @OneToOne
    @JoinColumn(name = "rentid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Rent rent;
    @OneToOne
    @JoinColumn(name = "agencyid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Agency agency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setRent(Rent rentByRentId) {
        this.rent = rent;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agencyByAgencyId) {
        this.agency = agency;
    }
}
