package fr.givemeacar.app.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    public Integer getId() {
        return id;
    }
}