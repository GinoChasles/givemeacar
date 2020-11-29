package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bill", schema = "givemeacar", catalog = "")
public class Bill {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "rent_id", nullable = false)
    private int rentId;
    @Column(name = "agency_id", nullable = false)
    private int agencyId;
    @OneToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Rent rentByRentId;
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Agency agencyByAgencyId;
}
