package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * Représentation des suffixes de rue
 */
@Data
@Entity
@Table(name = "street_suffices", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StreetSuffix  implements CrudModel{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //le nom du suffixe
    @Column(name = "name", nullable = true)
    private String name;

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

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreetSuffix)) return false;
        StreetSuffix that = (StreetSuffix) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
