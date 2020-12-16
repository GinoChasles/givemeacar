package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "cities", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @JsonIgnore
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Department department;
    @Column(name = "department_id", nullable = false)
    private int department_id;

    public String getDepartmentName(){
        return getDepartment().getName();
    }

    public String getRegionName(){
        return getDepartment().getRegion().getName();
    }

    public int getRegionId(){
        return getDepartment().getRegion().getId();
    }

}
