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
    private int available;
    @Column(name = "rented", nullable = false)
    private int rented;
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;

    @OneToOne
    @JsonIgnore
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
    @JsonIgnore
    @JoinColumn(name = "color_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Color color;



    /*  Model and brand */

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "model_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Model model;


    public boolean getAvailable() {
        return available != 0 ? true : false;
    }

    public boolean getRented() {
        return rented != 0 ? true : false;
    }

    public String getModelName() {
        if(model!= null){
        return model.getName();
        }
        return null;
    }

    public String getBrandName() {
        if(model!= null) {
            return model.getBrand().getName();
        }
        return null;
    }

    public int getBrandId() {
        if(model != null) {
            return model.getBrand().getId();
        }
        return 0;
    }


    public String getColorName() {
        if (color != null) {
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
