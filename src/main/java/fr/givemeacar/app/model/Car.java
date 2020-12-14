package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "cars", schema = "givemeacar")
public class Car  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    @JoinColumn(name = "modelid", referencedColumnName = "id",
            nullable = false, insertable = false,updatable = false)
    private Model model;
    @OneToOne
    @JoinColumn(name = "colorid", referencedColumnName = "id",
            nullable = false, insertable = false,updatable = false)
    private Color color;
    @OneToOne
    @JoinColumn(name = "energytypeid", referencedColumnName = "id",
            nullable = false, insertable = false,updatable = false)
    private EnergyType energyType;
    @JoinColumn(name = "modelid", referencedColumnName = "id", nullable = false)
    private int modelId;
    @JoinColumn(name = "colorid", referencedColumnName = "id", nullable = false)
    private int colorId;
    @JoinColumn(name = "energytypeid", referencedColumnName = "id",
            nullable = false)
    private int energyTypeId;
}
