package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "rents", schema = "givemeacar", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rent  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "start", nullable = false)
    private Timestamp start;
    @Column(name = "end", nullable = true)
    private Timestamp end;
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id",
            nullable = false,insertable = false,updatable = false)
    private Car car;
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id",
            nullable = false,insertable = false,updatable = false)
    private User user;

    @Column(name = "car_id", nullable = false)
    private int car_id;
    @Column(name = "client_id", nullable = false)
    private int client_id;

}
