package fr.givemeacar.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Le modèle représentant les agences de location
 */
@Entity
@Table(name = "agencies", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agency implements CrudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //le nom de l'agence
    @Column(name = "name", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆŠŽ∂ð ,.'-]{2,32}")
    private String name;

    //le numéro de rue de l'agence
    @Column(name = "street_number")
    private int streetNumber;

    //l'instance du modèle représentant le suffixe de rue de l'agence
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_suffix_id", referencedColumnName = "id", insertable = false,
            updatable = false)
    private StreetSuffix streetSuffix;

    //l'identifiant du suffixe de la rue en base de données
    @Column(name = "street_suffix_id")
    private int street_suffix_id;

    //l'instance du modèle représentant la rue de l'agence
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", referencedColumnName = "id",  insertable = false,
            updatable = false)
    private Street street;

    //l'identifiant de la rue en base de données
    @Column(name = "street_id", nullable = false)
    private int street_id;

    //l'unstance du modèle de la ville de l'agence
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id",  insertable = false, updatable = false)
    private City city;

    //l'identifiant de la ville en base de données

    @Column(name = "city_id", nullable = false)
    private int city_id;

    public int getStreetNumber(){
        return streetNumber;
    }

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public StreetSuffix getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(StreetSuffix streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public int getStreet_suffix_id() {
        return street_suffix_id;
    }

    public void setStreet_suffix_id(int street_suffix_id) {
        this.street_suffix_id = street_suffix_id;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public int getStreet_id() {
        return street_id;
    }

    public void setStreet_id(int street_id) {
        this.street_id = street_id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agency)) return false;
        Agency agency = (Agency) o;
        return getStreetNumber() == agency.getStreetNumber() &&
                getStreet_suffix_id() == agency.getStreet_suffix_id() &&
                getStreet_id() == agency.getStreet_id() &&
                getCity_id() == agency.getCity_id() &&
                Objects.equals(getId(), agency.getId()) &&
                Objects.equals(getName(), agency.getName()) &&
                Objects.equals(getStreetSuffix(), agency.getStreetSuffix()) &&
                Objects.equals(getStreet(), agency.getStreet()) &&
                Objects.equals(getCity(), agency.getCity());
    }

    @Override public int hashCode() {
        return Objects
                .hash(getId(), getName(), getStreetNumber(), getStreetSuffix(), getStreet_suffix_id(), getStreet(),
                        getStreet_id(), getCity(), getCity_id());
    }
}
