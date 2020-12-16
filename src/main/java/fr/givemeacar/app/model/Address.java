package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street street;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    @JsonIgnore
    private City city;
    @Column(name = "street_id", nullable = false)
    private int street_id;
    @Column(name = "city_id", nullable =
            false)
    private int city_id;

    public String getCityName(){
        return city.getName();
    }

    public String getStreetName(){
        return street.getStreetName().getName();
    }
}
