package fr.givemeacar.app.model;



import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name = "address", schema = "givemeacar", catalog = "")
public class Address implements CrudModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Column(name = "street_id", nullable = false)
    private int streetId;
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;
    @OneToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street streetByStreetId;
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Street getStreetByStreetId() {
        return streetByStreetId;
    }

    public void setStreetByStreetId(Street streetByStreetId) {
        this.streetByStreetId = streetByStreetId;
    }
}
