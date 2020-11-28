package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class City {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 68)
    private String name;
    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;
    @Column(name = "department_id", nullable = false)
    private int departmentId;
    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Department departmentByDepartmentId;
}
