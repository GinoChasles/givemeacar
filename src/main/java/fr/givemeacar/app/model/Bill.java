package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "bills", schema = "givemeacar")
public class Bill  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Column(name = "date", nullable = false)
    private Date date;
    @OneToOne
    @JoinColumn(name = "rent_id", referencedColumnName = "id",
            nullable = false, updatable = false,insertable = false)
    private Rent rent;
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id",
            nullable = false, updatable = false,insertable = false)
    private Agency agency;
    @Column(name = "rent_id", nullable = false)
    private int rent_id;
    @Column(name = "agency_id", nullable = false)
    private int agency_id;

}
