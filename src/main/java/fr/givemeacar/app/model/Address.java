package fr.givemeacar.app.model;



import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name = "addresses", schema = "givemeacar", catalog = "")
public class Address implements CrudModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Column(name = "number_suffix", length=6, nullable = true)
    private String numberSuffix;
    @Column(name = "street_id", nullable = false)
    private int streetId;
    @OneToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street streetByStreetId;

    @Column(name = "city_id", nullable = false)
    private int cityId;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street cityByCityId;

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

    public Street getStreetByStreetId() {
        return streetByStreetId;
    }

    public void setStreetByStreetId(Street streetByStreetId) {
        this.streetByStreetId = streetByStreetId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Street getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(Street cityByStreetId) {
        this.cityByCityId = cityByCityId;
    }

    public String getNumberSuffix() {
        return numberSuffix;
    }

    public void setNumberSuffix(String numberSuffix) {
        this.numberSuffix = numberSuffix;
    }
}
