package fr.givemeacar.app.model;



import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "rents", schema = "givemeacar", catalog = "")
public class Rent  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "start", nullable = false)
    private Timestamp start;
    @Column(name = "end", nullable = true)
    private Timestamp end;
    @OneToOne
    @JoinColumn(name = "carid", referencedColumnName = "id", nullable = false)
    private Car car;
    @OneToOne
    @JoinColumn(name = "clientid", referencedColumnName = "id", nullable = false)
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setCar(Car carByCarId) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client clientByClientId) {
        this.client = client;
    }
}
