package fr.givemeacar.app.model;



import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "streets", schema = "givemeacar", catalog = "")
public class Street  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToOne
    @JoinColumn(name = "cityid", referencedColumnName = "id", nullable = false)
    private City city;
    @OneToOne
    @JoinColumn(name = "streetnameid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private StreetName streetName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City cityByCityId) {
        this.city = city;
    }

    public StreetName getStreetName() {
        return streetName;
    }

    public void setStreetName(StreetName streetNameByStreetNameId) {
        this.streetName = streetName;
    }
}
