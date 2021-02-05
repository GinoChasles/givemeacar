package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.givemeacar.app.service.ManagerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "agencies", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agency implements CrudModel,HasAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String name;

    @Column(name = "street_number", nullable = true)
    private int streetNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "street_suffix_id", referencedColumnName = "id", nullable = true, insertable = false,
            updatable = false)
    private StreetSuffix streetSuffix;

    @Column(name = "street_suffix_id", nullable = false)
    private int street_suffix_id;

    /* Street */

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = true, insertable = false,
            updatable = false)
    private Street street;

    @Column(name = "street_id", nullable = false)
    private int street_id;

    /*  City  */

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    @JsonIgnore
    private City city;

    @Column(name = "city_id", nullable = false)
    private int city_id;

    @Column(name = "manager_id", nullable = false)
    private int manager_id;


    /** METHODES */


    public String getCityName() {
        if (city != null) {
            return city.getName();
        }
        return null;
    }

    public String getStreetName() {
        if (street != null) {
            return street.getName();
        }
        return null;
    }

    public String getStreetSuffixName() {
        if (streetSuffix != null) {
            return streetSuffix.getName();
        }
        return null;
    }


    public String getZipCode() {
        if (city != null) {
            return city.getZipcode();
        }
        return null;
    }

    public String getAddress(){
        return streetNumber + " " + streetSuffix.getName() + " " + street.getName() + " - " + getZipCode() + " " + city.getName();
    }
}
