package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * Représentation des départements
 */
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getRegion_id() == that.getRegion_id() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getRegion(), that.getRegion());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getCode(), getRegion(), getRegion_id());
    }
}
