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
    @Column(name = "modelid", nullable = false)
    private int modelid;
    @Column(name = "energyid", nullable = false)
    private int energyid;
    @Column(name = "colorid", nullable = false)
    private int colorid;
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;
    @OneToOne
    @JoinColumn(name = "modelid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Model modelByModelid;
    @OneToOne
    @JoinColumn(name = "colorid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Color colorByColorid;
    @OneToOne
    @JoinColumn(name = "energyTypeid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private EnergyType energyTypeByEnergyTypeid;
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address addressByAddressid;

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

    public int getModelid() {
        return modelid;
    }

    public void setModelid(int modelid) {
        this.modelid = modelid;
    }

    public int getEnergyid() {
        return energyid;
    }

    public void setEnergyid(int energyid) {
        this.energyid = energyid;
    }

    public int getColorid() {
        return colorid;
    }

    public void setColorid(int colorid) {
        this.colorid = colorid;
    }

    public Model getModelByModelid() {
        return modelByModelid;
    }

    public void setModelByModelid(Model modelByModelid) {
        this.modelByModelid = modelByModelid;
    }

    public Color getColorByColorid() {
        return colorByColorid;
    }

    public void setColorByColorid(Color colorByColorid) {
        this.colorByColorid = colorByColorid;
    }

    public EnergyType getEnergyTypeByEnergyTypeid() {
        return energyTypeByEnergyTypeid;
    }

    public void setEnergyTypeByEnergyTypeid(EnergyType energyTypeByEnergyTypeid) {
        this.energyTypeByEnergyTypeid = energyTypeByEnergyTypeid;
    }

    public Address getAddressByAddressid() {
        return addressByAddressid;
    }

    public void setAddressByAddressid(Address addressByAddressid) {
        this.addressByAddressid = addressByAddressid;
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
