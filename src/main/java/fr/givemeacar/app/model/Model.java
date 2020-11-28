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
public class Model {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "brand_id", nullable = false)
    private int brandId;
    @OneToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Brand brandByBrandId;
}
