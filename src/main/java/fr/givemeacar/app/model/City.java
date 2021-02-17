package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * Le modèle représentant les villes
 */
@Data
@Entity
@Table(name = "cities", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City implements CrudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    //le nom de la ville
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,68}")
    @Column(name = "name", nullable = false)
    private String name;

    //le zipcode de la ville
    @Pattern(regexp = "[0-9]{5}")
    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;

    //la longitude de la ville
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;

    //la laltitude de la ville
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;

    //le modèle représentant le département où est située la ville
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false, updatable = false,
            insertable = false)
    private Department department;

    //l'identifiant du département dans le quel se situe la vilel
    @Column(name = "department_id", nullable = false)
    private int department_id;

    //le nom du département dans lequel se situe la ville
    public String getDepartmentName() {
        if (getDepartment() != null) {
            return getDepartment().getName();
        }
        return null;
    }

    //le nom de la région dans laquelle se situe la vilel
    public String getRegionName() {
        if (getDepartment() != null) {
            if (getDepartment().getRegion() != null) {
                return getDepartment().getRegion().getName();
            }
        }
        return null;
    }

    //l'identifiant de la région dnasl aquelle se situe la ville
    public Integer getRegionId() {
        if (getDepartment() != null) {
            if (getDepartment().getRegion() != null) {
                return getDepartment().getRegion().getId();
            }
        }
        return null;
    }

}
