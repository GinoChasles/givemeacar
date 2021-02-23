package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Le modèle représentant les voitures
 */
@Data
@Entity
@Table(name = "cars", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car implements CrudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //le kilométrage de la voiture
    @Column(name = "kilometers", nullable = false)
    private int kilometers;

    //le prix de la location de la voiture
    @Column(name = "price", nullable = false)
    private Double price;

    //l'année de construction de la voiture
    @Column(name = "year", nullable = false)
    private int year;

    //la disponibilité de la voiture
    @Column(name = "available", nullable = false, columnDefinition = "BOOLEAN")
    private boolean available;

    //l'état de location de la voiture (une voiture peut être non disponible car elle est en maintenance et pas en
    // location)
    @Column(name = "rented", nullable = false, columnDefinition = "BOOLEAN")
    private boolean rented;

    //la longitude de la voiture pour la géolocalisation
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;

    //la latitude de la voiture pour la géolocalisation
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;

    //l'instance du modèle de type d'énergie de la voiture
    @OneToOne
    @JoinColumn(name = "energy_type_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private EnergyType energyType;

    //l'id du type d'énergie de la voiture
    @Column(name = "energy_type_id", nullable = false)
    private Integer energy_type_id;

    //le niveau d'énergie maximal de la voiture
    @Column(name = "energy_max", nullable = false)
    private Double energyMax;

    //le niveau dénergie courant de la voiture
    @Column(name = "energy_current", nullable = false)
    private Double energyCurrent;

    //l'instance du modèle du modèle de la voiture
    @OneToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Model model;

    //l'identifiant du modèle de la voiture
    @Column(name = "model_id", nullable = false)
    private Integer model_id;
    
    //l'instance du modèle de la couleur de la voiture
    @OneToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Color color;

    //l'identifiant de la couleur de la voiture
    @Column(name = "color_id", nullable = false)
    private Integer color_id;

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
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

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public Integer getEnergy_type_id() {
        return energy_type_id;
    }

    public void setEnergy_type_id(Integer energy_type_id) {
        this.energy_type_id = energy_type_id;
    }

    public Double getEnergyMax() {
        return energyMax;
    }

    public void setEnergyMax(Double energyMax) {this.energyMax = energyMax;}

    public Double getEnergyCurrent() {
        return energyCurrent;
    }

    public void setEnergyCurrent(Double energyCurrent) {
        this.energyCurrent = energyCurrent;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }


    //le nom du modèle de la voiture
    public String getModelName() {
        if (model != null) {
            return model.getName();
        }
        return null;
    }

    //le nom de la marque de la voiture
    public String getBrandName() {
        if (model != null) {
            return model.getBrand().getName();
        }
        return null;
    }

    //le niveau d'énergie courant sur le niveau d'énergie maximal
    public String getEnergyLevel() {
        if(energyCurrent != null && energyMax != null){
            return energyCurrent + " / " + energyMax;
        }
        return null;
    }

    //le nom de la couleur de la voiture
    public String getColorName() {
        if (color != null) {
            return color.getName();
        }
        return null;
    }

    //le nom du type dénergie de la voiture
    public String getEnergy() {
        if (energyType != null) {
            return energyType.getName();
        }
        return null;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getKilometers() == car.getKilometers() &&
                getYear() == car.getYear() &&
                isAvailable() == car.isAvailable() &&
                isRented() == car.isRented() &&
                Objects.equals(getId(), car.getId()) &&
                Objects.equals(getPrice(), car.getPrice()) &&
                Objects.equals(getLongitude(), car.getLongitude()) &&
                Objects.equals(getLatitude(), car.getLatitude()) &&
                Objects.equals(getEnergyType(), car.getEnergyType()) &&
                Objects.equals(getEnergy_type_id(), car.getEnergy_type_id()) &&
                Objects.equals(getEnergyMax(), car.getEnergyMax()) &&
                Objects.equals(getEnergyCurrent(), car.getEnergyCurrent()) &&
                Objects.equals(getModel(), car.getModel()) &&
                Objects.equals(getModel_id(), car.getModel_id()) &&
                Objects.equals(getColor(), car.getColor()) &&
                Objects.equals(getColor_id(), car.getColor_id());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getKilometers(), getPrice(), getYear(), isAvailable(), isRented(), getLongitude(),
                getLatitude(), getEnergyType(), getEnergy_type_id(), getEnergyMax(), getEnergyCurrent(), getModel(),
                getModel_id(), getColor(), getColor_id());
    }
}
