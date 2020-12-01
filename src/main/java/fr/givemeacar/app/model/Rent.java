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
    @Column(name = "carid", nullable = false)
    private int carid;
    @Column(name = "clientid", nullable = false)
    private int clientid;
    @OneToOne
    @JoinColumn(name = "carid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Car carByCarid;
    @OneToOne
    @JoinColumn(name = "clientid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Client clientByClientid;

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

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public Car getCarByCarid() {
        return carByCarid;
    }

    public void setCarByCarid(Car carByCarid) {
        this.carByCarid = carByCarid;
    }

    public Client getClientByClientid() {
        return clientByClientid;
    }

    public void setClientByClientid(Client clientByClientid) {
        this.clientByClientid = clientByClientid;
    }
}
