package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "departments", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "code", nullable = true, length = 45)
    private String code;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "region_id", referencedColumnName = "id",
            nullable = false, insertable = false,updatable = false)
    private Region region;

    @Column(name = "region_id", nullable = false)
    private int region_id;

    public String getRegionName(){
        return getRegion().getName();
    }
}
