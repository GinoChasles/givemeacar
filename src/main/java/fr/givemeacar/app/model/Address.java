package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "addresses", schema = "givemeacar")
public class Address implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Pattern(regexp = "[a-zA-Z]{0,6}")
    @NotBlank
    @Column(name = "numbersuffix", nullable = true)
    private String numberSuffix;
    @OneToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street street;
    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street city;
    @Column(name = "street_id", nullable = false)
    private int street_id;
    @Column(name = "city_id", nullable =
            false)
    private int city_id;
}
