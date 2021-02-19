package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "rents", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rent  implements CrudModel{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //le début de la location
    @Column(name = "start", nullable = false)
    private Timestamp start;

    //la fin de la location
    @Column(name = "end")
    private Timestamp end;

    //la voiture louée
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id",
            nullable = false,insertable = false,updatable = false)
    private Car car;

    //l'utilisateur qui a loué la voiture
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id",
            nullable = false,insertable = false,updatable = false)
    private User user;

    //l'identifiant de la voiture louée
    @Column(name = "car_id", nullable = false)
    private int car_id;

    //l'identifiant de l'utilisateur qui a loué la voiture
    @Column(name = "client_id", nullable = false)
    private int client_id;
}
