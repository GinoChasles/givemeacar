package fr.givemeacar.app.model;



import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "street", schema = "givemeacar", catalog = "")
public class Street {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "city_id", nullable = false)
    private int cityId;
    @Column(name = "street_name_id", nullable = false)
    private int streetNameId;
    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private City cityByCityId;
    @OneToOne
    @JoinColumn(name = "street_name_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private StreetName streetNameByStreetNameId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStreetNameId() {
        return streetNameId;
    }

    public void setStreetNameId(int streetNameId) {
        this.streetNameId = streetNameId;
    }

    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    public StreetName getStreetNameByStreetNameId() {
        return streetNameByStreetNameId;
    }

    public void setStreetNameByStreetNameId(StreetName streetNameByStreetNameId) {
        this.streetNameByStreetNameId = streetNameByStreetNameId;
    }
}
