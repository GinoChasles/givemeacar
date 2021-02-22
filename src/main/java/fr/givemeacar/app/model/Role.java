package fr.givemeacar.app.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * Représentation des rôles utilisateurs
 */
@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //le nom du rôle
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId()) &&
                Objects.equals(getName(), role.getName());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}