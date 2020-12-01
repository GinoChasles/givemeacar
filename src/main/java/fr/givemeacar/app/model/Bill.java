package fr.givemeacar.app.model;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "bill", schema = "givemeacar", catalog = "")
public class Bill {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "rent_id", nullable = false)
    private int rentId;
    @Column(name = "agency_id", nullable = false)
    private int agencyId;
    @OneToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Rent rentByRentId;
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Agency agencyByAgencyId;

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

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public Rent getRentByRentId() {
        return rentByRentId;
    }

    public void setRentByRentId(Rent rentByRentId) {
        this.rentByRentId = rentByRentId;
    }

    public Agency getAgencyByAgencyId() {
        return agencyByAgencyId;
    }

    public void setAgencyByAgencyId(Agency agencyByAgencyId) {
        this.agencyByAgencyId = agencyByAgencyId;
    }
}
