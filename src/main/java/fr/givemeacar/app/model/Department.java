package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Représentation des départements
 */
@Data
@Entity
@Table(name = "departments", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department implements CrudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //le nom du département
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    //le code du département
    @Column(name = "code", nullable = true, length = 45)
    private String code;

    //la région dans laquelle se situe le département
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "region_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Region region;

    //l'identifiant de la région dans laquelle se situe le département
    @Column(name = "region_id", nullable = false)
    private int region_id;

    //le nom de la région dnas laquelle se situe le département
    public String getRegionName() {
        if (getRegion() != null) {
            return getRegion().getName();
        }
        return null;
    }
}
