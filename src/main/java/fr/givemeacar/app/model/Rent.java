package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "rents", schema = "givemeacar", catalog = "")
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
    @JoinColumn(name = "carid", referencedColumnName = "id",
            nullable = false,insertable = false,updatable = false)
    private Car car;
    @OneToOne
    @JoinColumn(name = "clientid", referencedColumnName = "id",
            nullable = false,insertable = false,updatable = false)
    private Client client;

    @JoinColumn(name = "carid", referencedColumnName = "id", nullable = false)
    private int carId;
    @JoinColumn(name = "clientid", referencedColumnName = "id", nullable = false)
    private int clientId;

}
