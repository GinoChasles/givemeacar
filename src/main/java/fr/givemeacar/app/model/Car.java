package fr.givemeacar.app.model;



import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "car", schema = "givemeacar", catalog = "")
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "kilometers", nullable = false)
    private int kilometers;
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "available", nullable = false)
    private int available;
    @Column(name = "rented", nullable = false)
    private int rented;
    @Column(name = "model_id", nullable = false)
    private int modelId;
    @Column(name = "energy_id", nullable = false)
    private int energyId;
    @Column(name = "color_id", nullable = false)
    private int colorId;
    @OneToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Model modelByModelId;
    @OneToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Color colorByColorId;
    @OneToOne
    @JoinColumn(name = "energy_type_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private EnergyType energyTypeByEnergyTypeId;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address addressByAddressId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getRented() {
        return rented;
    }

    public void setRented(int rented) {
        this.rented = rented;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getEnergyId() {
        return energyId;
    }

    public void setEnergyId(int energyId) {
        this.energyId = energyId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public Model getModelByModelId() {
        return modelByModelId;
    }

    public void setModelByModelId(Model modelByModelId) {
        this.modelByModelId = modelByModelId;
    }

    public Color getColorByColorId() {
        return colorByColorId;
    }

    public void setColorByColorId(Color colorByColorId) {
        this.colorByColorId = colorByColorId;
    }

    public EnergyType getEnergyTypeByEnergyTypeId() {
        return energyTypeByEnergyTypeId;
    }

    public void setEnergyTypeByEnergyTypeId(EnergyType energyTypeByEnergyTypeId) {
        this.energyTypeByEnergyTypeId = energyTypeByEnergyTypeId;
    }

    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
