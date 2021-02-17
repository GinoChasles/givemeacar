package fr.givemeacar.app.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


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
}