package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "cars", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car implements CrudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "kilometers", nullable = false)
    private int kilometers;
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "available", nullable = false)
    @JsonIgnore
    private int available;
    @Column(name = "rented", nullable = false)
    @JsonIgnore
    private int rented;
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;

    @OneToOne
    @JoinColumn(name = "energy_type_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private EnergyType energyType;
    @Column(name = "energy_max", nullable = false)
    private double energyMax;
    @Column(name = "energy_current", nullable = false)
    private double energyCurrent;
    @Column(name = "model_id", nullable = false)
    private int model_id;
    @Column(name = "color_id", nullable = false)
    private int color_id;
    @Column(name = "energy_type_id", nullable = false)
    private int energy_type_id;
    @OneToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Color color;

    public String getAvailability() {
        return available != 0 ? "oui" : "non";
    }

    public String getInRent() {
        return rented != 0 ? "oui" : "non";
    }


    /*  Model and brand */

    @OneToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Model model;

    public String getModelName() {
        return getModel().getName();
    }

    public String getBrandName() {
        return getModel().getBrand().getName();
    }

    public int getBrandId() {
        return getModel().getBrand().getId();
    }

    public String getEnergyLevel() {
        return getEnergyCurrent() + " / " + getEnergyMax();
    }
    
    public String getColorName() {
        if (getColor() != null) {
            return getColor().getName();
        }
        return null;
    }

    public String getEnergy() {
        if (getEnergyType() != null) {
            return getEnergyType().getName();
        }
        return null;
    }
}
