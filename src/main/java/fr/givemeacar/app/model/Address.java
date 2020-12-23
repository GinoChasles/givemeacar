package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements CrudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Pattern(regexp = "[a-zA-Z]{0,6}")
    @NotBlank
    @Column(name = "suffix", nullable = true)
    private String suffix;

    /* Street */

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false, insertable = false,
            updatable = false)
    private Street street;

    @Column(name = "street_id", nullable = false)
    private int street_id;

    /*  City  */

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private City city;

    public String getCityName() {
        if (getCity() != null) {
            return getCity().getName();
        }
        return null;
    }

    public String getStreetName() {
        if (getStreet() != null) {
            return getStreet().getName();
        }
        return null;
    }

    public String getZipCode() {
        if (getCity() != null) {
            return getCity().getZipcode();
        }
        return null;
    }

    public String toString() {
        if (getStreet() != null && getCity() != null) {
            if (getStreet().getName() != null && getCity().getZipcode() != null && getCity().getName() != null)
                return number + " " + suffix + " " +
                        street.getName() + " - " + city.getZipcode() + " " + city.getName();
        }
        return null;
    }
}
