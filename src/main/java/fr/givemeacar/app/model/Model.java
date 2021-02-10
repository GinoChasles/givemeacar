package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "models", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Model implements CrudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    /* Brand */

    @OneToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Brand brand;

    @Column(name = "brand_id", nullable = false)
    private int brand_id;

    public String getBrandName() {
        if (brand != null) {
            return brand.getName();
        }
        return null;
    }

    public String getFullName() {
        if (brand != null) {
            return brand.getName() + " " + name;
        }
        return null;
    }
}
