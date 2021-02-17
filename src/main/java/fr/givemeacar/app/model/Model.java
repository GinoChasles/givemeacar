package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Représentation du modèle de véhicule
 */
@Data
@Entity
@Table(name = "models", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Model implements CrudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆŠŽ∂ð ,.'-]{2,32}")
    private int id;

    //le nom du modèle
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    //l'instance de modèle de la marque du modèle
    @OneToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Brand brand;

    //l'identifiant de la marque du modèle
    @Column(name = "brand_id", nullable = false)
    private int brand_id;

    //le nom de la marque du modèle
    public String getBrandName() {
        if (getBrand() != null) {
            return getBrand().getName();
        }
        return null;
    }
}
