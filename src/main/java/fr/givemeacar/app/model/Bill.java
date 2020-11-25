package fr.givemeacar.app.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Bill {
    private int id;
    private double price;
    private Date date;
    private int rentId;
    private int agencyId;
    private Collection<Agency> agenciesById;
    private Rent rentByRentId;
    private Agency agencyByAgencyId;
    private Collection<Client> clientsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "rent_id", nullable = false)
    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    @Basic
    @Column(name = "agency_id", nullable = false)
    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (id != bill.id) return false;
        if (Double.compare(bill.price, price) != 0) return false;
        if (rentId != bill.rentId) return false;
        if (agencyId != bill.agencyId) return false;
        if (date != null ? !date.equals(bill.date) : bill.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + rentId;
        result = 31 * result + agencyId;
        return result;
    }

    @OneToMany(mappedBy = "billByBillId")
    public Collection<Agency> getAgenciesById() {
        return agenciesById;
    }

    public void setAgenciesById(Collection<Agency> agenciesById) {
        this.agenciesById = agenciesById;
    }

    @ManyToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "id", nullable = false)
    public Rent getRentByRentId() {
        return rentByRentId;
    }

    public void setRentByRentId(Rent rentByRentId) {
        this.rentByRentId = rentByRentId;
    }

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false)
    public Agency getAgencyByAgencyId() {
        return agencyByAgencyId;
    }

    public void setAgencyByAgencyId(Agency agencyByAgencyId) {
        this.agencyByAgencyId = agencyByAgencyId;
    }

    @OneToMany(mappedBy = "billByBillId")
    public Collection<Client> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Collection<Client> clientsById) {
        this.clientsById = clientsById;
    }
}
