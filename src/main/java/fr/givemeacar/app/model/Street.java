package fr.givemeacar.app.model;



import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "streets", schema = "givemeacar", catalog = "")
public class Street  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "cityid", nullable = false)
    private int cityid;
    @Column(name = "streetNameid", nullable = false)
    private int streetNameid;
    @OneToOne
    @JoinColumn(name = "cityid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private City cityByCityid;
    @OneToOne
    @JoinColumn(name = "streetNameid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private StreetName streetNameByStreetNameid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getStreetNameid() {
        return streetNameid;
    }

    public void setStreetNameid(int streetNameid) {
        this.streetNameid = streetNameid;
    }

    public City getCityByCityid() {
        return cityByCityid;
    }

    public void setCityByCityid(City cityByCityid) {
        this.cityByCityid = cityByCityid;
    }

    public StreetName getStreetNameByStreetNameid() {
        return streetNameByStreetNameid;
    }

    public void setStreetNameByStreetNameid(StreetName streetNameByStreetNameid) {
        this.streetNameByStreetNameid = streetNameByStreetNameid;
    }
}
