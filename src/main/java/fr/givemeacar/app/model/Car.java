package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
