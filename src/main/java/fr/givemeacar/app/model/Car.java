package fr.givemeacar.app.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    private int id;
    private int kilometers;
    private double price;
    private int year;
    private int availability;
    private int onRent;
    private int modelId;
    private int energyId;
    private int rentId;
    private int colorId;
    private int geolocationId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "kilometers", nullable = false)
    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
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
    @Column(name = "year", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "availability", nullable = false)
    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Basic
    @Column(name = "onRent", nullable = false)
    public int getOnRent() {
        return onRent;
    }

    public void setOnRent(int onRent) {
        this.onRent = onRent;
    }

    @Basic
    @Column(name = "model_id", nullable = false)
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    @Basic
    @Column(name = "energy_id", nullable = false)
    public int getEnergyId() {
        return energyId;
    }

    public void setEnergyId(int energyId) {
        this.energyId = energyId;
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
    @Column(name = "color_id", nullable = false)
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "geolocation_id", nullable = false)
    public int getGeolocationId() {
        return geolocationId;
    }

    public void setGeolocationId(int geolocationId) {
        this.geolocationId = geolocationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (kilometers != car.kilometers) return false;
        if (Double.compare(car.price, price) != 0) return false;
        if (year != car.year) return false;
        if (availability != car.availability) return false;
        if (onRent != car.onRent) return false;
        if (modelId != car.modelId) return false;
        if (energyId != car.energyId) return false;
        if (rentId != car.rentId) return false;
        if (colorId != car.colorId) return false;
        if (geolocationId != car.geolocationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + kilometers;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + year;
        result = 31 * result + availability;
        result = 31 * result + onRent;
        result = 31 * result + modelId;
        result = 31 * result + energyId;
        result = 31 * result + rentId;
        result = 31 * result + colorId;
        result = 31 * result + geolocationId;
        return result;
    }
}
