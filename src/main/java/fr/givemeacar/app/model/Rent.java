package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rent", schema = "givemeacar", catalog = "")
public class Rent {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "start", nullable = false)
    private Timestamp start;
    @Column(name = "end", nullable = true)
    private Timestamp end;
    @Column(name = "car_id", nullable = false)
    private int carId;
    @Column(name = "client_id", nullable = false)
    private int clientId;
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Car carByCarId;
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Client clientByClientId;
}
