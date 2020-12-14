package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "cities", schema = "givemeacar")
public class City  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,68}")
    @Column(name = "name", nullable = false)
    private String name;
    @Pattern(regexp = "[0-9]{5}")
    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;
    @OneToOne
    @JoinColumn(name = "departmentid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Department department;
    @JoinColumn(name = "departmentid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private int departmentById;

}
