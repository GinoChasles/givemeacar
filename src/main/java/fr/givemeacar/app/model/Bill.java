package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "bills", schema = "givemeacar", catalog = "")
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
    @JoinColumn(name = "rentid", referencedColumnName = "id", nullable = false)
    private Rent rent;
    @OneToOne
    @JoinColumn(name = "agencyid", referencedColumnName = "id", nullable = false)
    private Agency agency;

}
