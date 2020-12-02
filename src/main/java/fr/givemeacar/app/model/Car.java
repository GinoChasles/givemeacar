package fr.givemeacar.app.model;



import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "cars", schema = "givemeacar", catalog = "")
public class Car  implements CrudModel{
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
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;
    @OneToOne
    @JoinColumn(name = "modelid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Model model;
    @OneToOne
    @JoinColumn(name = "colorid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Color color;
    @OneToOne
    @JoinColumn(name = "energyTypeid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private EnergyType energyType;
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address address;

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

    public Model getModel() {
        return model;
    }

    public void setModel(Model modelByModelId) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color colorByColorId) {
        this.color = color;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyTypeByEnergyTypeId) {
        this.energyType = energyType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressByAddressId) {
        this.address = address;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
