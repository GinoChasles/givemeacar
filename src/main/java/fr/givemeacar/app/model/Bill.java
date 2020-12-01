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
    @Column(name = "rentid", nullable = false)
    private int rentid;
    @Column(name = "agencyid", nullable = false)
    private int agencyid;
    @OneToOne
    @JoinColumn(name = "rentid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Rent rentByRentid;
    @OneToOne
    @JoinColumn(name = "agencyid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Agency agencyByAgencyid;

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

    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
    }

    public int getAgencyid() {
        return agencyid;
    }

    public void setAgencyid(int agencyid) {
        this.agencyid = agencyid;
    }

    public Rent getRentByRentid() {
        return rentByRentid;
    }

    public void setRentByRentid(Rent rentByRentid) {
        this.rentByRentid = rentByRentid;
    }

    public Agency getAgencyByAgencyid() {
        return agencyByAgencyid;
    }

    public void setAgencyByAgencyid(Agency agencyByAgencyid) {
        this.agencyByAgencyid = agencyByAgencyid;
    }
}
