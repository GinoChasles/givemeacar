package fr.givemeacar.app.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Rent {
    private int id;
    private Timestamp start;
    private Timestamp end;
    private int carId;
    private int clientId;
    private Collection<Bill> billsById;
    private Collection<Car> carsById;
    private Car carByCarId;
    private Client clientByClientId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start", nullable = false)
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end", nullable = true)
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Basic
    @Column(name = "car_id", nullable = false)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "client_id", nullable = false)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        if (id != rent.id) return false;
        if (carId != rent.carId) return false;
        if (clientId != rent.clientId) return false;
        if (start != null ? !start.equals(rent.start) : rent.start != null) return false;
        if (end != null ? !end.equals(rent.end) : rent.end != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + carId;
        result = 31 * result + clientId;
        return result;
    }

    @OneToMany(mappedBy = "rentByRentId")
    public Collection<Bill> getBillsById() {
        return billsById;
    }

    public void setBillsById(Collection<Bill> billsById) {
        this.billsById = billsById;
    }

    @OneToMany(mappedBy = "rentByRentId")
    public Collection<Car> getCarsById() {
        return carsById;
    }

    public void setCarsById(Collection<Car> carsById) {
        this.carsById = carsById;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    public Car getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(Car carByCarId) {
        this.carByCarId = carByCarId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
