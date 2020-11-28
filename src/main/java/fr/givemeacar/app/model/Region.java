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
@Table(name = "region", schema = "givemeacar", catalog = "")
public class Region {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "country_id", nullable = false)
    private int countryId;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Country countryByCountryId;
}
