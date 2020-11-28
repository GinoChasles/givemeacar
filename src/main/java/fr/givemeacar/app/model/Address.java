package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address", schema = "givemeacar", catalog = "")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Column(name = "street_id", nullable = false)
    private int streetId;
    @Column(name = "street_suffix_id", nullable = false)
    private int streetSuffixId;
    @Column(name = "longitude", nullable = false, precision = 8)
    private BigDecimal longitude;
    @Column(name = "lattitude", nullable = false, precision = 8)
    private BigDecimal lattitude;
    @OneToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street streetByStreetId;
    @OneToOne
    @JoinColumn(name = "street_suffix_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private StreetSuffix streetSuffixByStreetSuffixId1;

}
