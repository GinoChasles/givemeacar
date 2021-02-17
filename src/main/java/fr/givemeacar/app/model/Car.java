package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private int id;

    //le kilométrage de la voiture
    @Column(name = "kilometers", nullable = false)
    private int kilometers;

    //le prix de la location de la voiture
    @Column(name = "price", nullable = false)
    private double price;

    //l'année de construction de la voiture
    @Column(name = "year", nullable = false)
    private int year;

    //la disponibilité de la voiture
    @Column(name = "available", nullable = false)
    @JsonIgnore
    private int available;

    //l'état de location de la voiture (une voiture peut être non disponible car elle est en maintenance et pas en
    // location)
    @Column(name = "rented", nullable = false)
    @JsonIgnore
    private int rented;

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
    private EnergyType energyType;

    //l'id du type d'énergie de la voiture
    @Column(name = "energy_type_id", nullable = false)
    private int energy_type_id;

    //le niveau d'énergie maximal de la voiture
    @Column(name = "energy_max", nullable = false)
    private double energyMax;

    //le niveau dénergie courant de la voiture
    @Column(name = "energy_current", nullable = false)
    private double energyCurrent;

    //l'instance du modèle du modèle de la voiture
    @OneToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Model model;

    //l'identifiant du modèle de la voiture
    @Column(name = "model_id", nullable = false)
    private int model_id;


    //l'instance du modèle de la couleur de la voiture
    @OneToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Color color;
    //l'identifiant de la couleur de la voiture
    @Column(name = "color_id", nullable = false)
    private int color_id;

    //le nom du modèle de la voiture
    public String getModelName() {
        return getModel().getName();
    }

    //le nom de la marque de la voiture
    public String getBrandName() {
        return getModel().getBrand().getName();
    }

    //l'identifiant de la marque de la voiture
    public int getBrandId() {
        return getModel().getBrand().getId();
    }

    //le niveau d'énergie courant sur le niveau d'énergie maximal
    public String getEnergyLevel() {
        return getEnergyCurrent() + " / " + getEnergyMax();
    }

    //le nom de la couleur de la voiture
    public String getColorName() {
        if (getColor() != null) {
            return getColor().getName();
        }
        return null;
    }

    //le nom du type dénergie de la voiture
    public String getEnergy() {
        if (getEnergyType() != null) {
            return getEnergyType().getName();
        }
        return null;
    }
}
