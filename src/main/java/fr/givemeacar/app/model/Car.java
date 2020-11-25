package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Car {
    private int id;
    private int kilometers;
    private double price;
    private int year;
    private Object availability;
    private Object onRent;
    private int colorId1;
    private int geolocationId1;
    private int modelId;
    private int energyId;
    private int rentId;
    private Color colorByColorId1;
    private Geolocation geolocationByGeolocationId1;
    private Model modelByModelId;
    private Energy energyByEnergyId;
    private Rent rentByRentId;
    private Collection<Rent> rentsById;

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
    public Object getAvailability() {
        return availability;
    }

    public void setAvailability(Object availability) {
        this.availability = availability;
    }

    @Basic
    @Column(name = "onRent", nullable = false)
    public Object getOnRent() {
        return onRent;
    }

    public void setOnRent(Object onRent) {
        this.onRent = onRent;
    }

    @Basic
    @Column(name = "color_id1", nullable = false)
    public int getColorId1() {
        return colorId1;
    }

    public void setColorId1(int colorId1) {
        this.colorId1 = colorId1;
    }

    @Basic
    @Column(name = "geolocation_id1", nullable = false)
    public int getGeolocationId1() {
        return geolocationId1;
    }

    public void setGeolocationId1(int geolocationId1) {
        this.geolocationId1 = geolocationId1;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (kilometers != car.kilometers) return false;
        if (Double.compare(car.price, price) != 0) return false;
        if (year != car.year) return false;
        if (colorId1 != car.colorId1) return false;
        if (geolocationId1 != car.geolocationId1) return false;
        if (modelId != car.modelId) return false;
        if (energyId != car.energyId) return false;
        if (rentId != car.rentId) return false;
        if (availability != null ? !availability.equals(car.availability) : car.availability != null) return false;
        if (onRent != null ? !onRent.equals(car.onRent) : car.onRent != null) return false;

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
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (onRent != null ? onRent.hashCode() : 0);
        result = 31 * result + colorId1;
        result = 31 * result + geolocationId1;
        result = 31 * result + modelId;
        result = 31 * result + energyId;
        result = 31 * result + rentId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "color_id1", referencedColumnName = "id", nullable = false)
    public Color getColorByColorId1() {
        return colorByColorId1;
    }

    public void setColorByColorId1(Color colorByColorId1) {
        this.colorByColorId1 = colorByColorId1;
    }

    @ManyToOne
    @JoinColumn(name = "geolocation_id1", referencedColumnName = "id", nullable = false)
    public Geolocation getGeolocationByGeolocationId1() {
        return geolocationByGeolocationId1;
    }

    public void setGeolocationByGeolocationId1(Geolocation geolocationByGeolocationId1) {
        this.geolocationByGeolocationId1 = geolocationByGeolocationId1;
    }

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    public Model getModelByModelId() {
        return modelByModelId;
    }

    public void setModelByModelId(Model modelByModelId) {
        this.modelByModelId = modelByModelId;
    }

    @ManyToOne
    @JoinColumn(name = "energy_id", referencedColumnName = "id", nullable = false)
    public Energy getEnergyByEnergyId() {
        return energyByEnergyId;
    }

    public void setEnergyByEnergyId(Energy energyByEnergyId) {
        this.energyByEnergyId = energyByEnergyId;
    }

    @ManyToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "id", nullable = false)
    public Rent getRentByRentId() {
        return rentByRentId;
    }

    public void setRentByRentId(Rent rentByRentId) {
        this.rentByRentId = rentByRentId;
    }

    @OneToMany(mappedBy = "carByCarId")
    public Collection<Rent> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<Rent> rentsById) {
        this.rentsById = rentsById;
    }
}
