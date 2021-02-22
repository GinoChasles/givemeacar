package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/***
 * Représentation des rues
 */
@Data
@Entity
@Table(name = "streets", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Street  implements CrudModel{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //le nom de la rue
    @Column(name = "name", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆŠŽ∂ð ,.'-]{2,45}")
    private String name;

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Street)) return false;
        Street street = (Street) o;
        return Objects.equals(getId(), street.getId()) &&
                Objects.equals(name, street.name);
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), name);
    }
}
