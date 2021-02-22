package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Objects;

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
    private Integer id;

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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return getBrand_id() == model.getBrand_id() &&
                Objects.equals(getId(), model.getId()) &&
                Objects.equals(getName(), model.getName()) &&
                Objects.equals(getBrand(), model.getBrand());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getBrand(), getBrand_id());
    }
}
