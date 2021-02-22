package fr.givemeacar.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

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

    public String getStreetNumber(){
        return Integer.toString(streetNumber);
    }

}
