package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Street {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "city_id", nullable = false)
    private int cityId;
    @Column(name = "street_name_id", nullable = false)
    private int streetNameId;
    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private City cityByCityId;
    @OneToOne
    @JoinColumn(name = "street_name_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private StreetName streetNameByStreetNameId;
}
