package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "department", schema = "givemeacar", catalog = "")
public class Department {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "code", nullable = true, length = 45)
    private String code;
    @Column(name = "region_id", nullable = false)
    private int regionId;
    @OneToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Region regionByRegionId;
}
