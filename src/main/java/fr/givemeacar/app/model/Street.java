package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "streets", schema = "givemeacar", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Street  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private City city;
    @OneToOne
    @JoinColumn(name = "street_name_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private StreetName streetName;

    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private int city_id;
    @Column(name = "street_name_id", nullable = false)
    private int street_name_id;

}
