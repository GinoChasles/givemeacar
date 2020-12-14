package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "cities", schema = "givemeacar", catalog = "")
public class City  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 68)
    private String name;
    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;
    @OneToOne
    @JoinColumn(name = "departmentid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Department department;

}
