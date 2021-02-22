package fr.givemeacar.app.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


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

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rent)) return false;
        Rent rent = (Rent) o;
        return getCar_id() == rent.getCar_id() &&
                getClient_id() == rent.getClient_id() &&
                Objects.equals(getId(), rent.getId()) &&
                Objects.equals(getStart(), rent.getStart()) &&
                Objects.equals(getEnd(), rent.getEnd()) &&
                Objects.equals(getCar(), rent.getCar()) &&
                Objects.equals(getUser(), rent.getUser());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getStart(), getEnd(), getCar(), getUser(), getCar_id(), getClient_id());
    }
}
