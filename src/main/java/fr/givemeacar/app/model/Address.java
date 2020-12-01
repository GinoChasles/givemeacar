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
    @Column(name = "numberSuffix", length=6, nullable = true)
    private String numberSuffix;
    @Column(name = "streetid", nullable = false)
    private int streetid;
    @OneToOne
    @JoinColumn(name = "streetid", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street streetByStreetid;

    @Column(name = "cityid", nullable = false)
    private int cityid;

    @OneToOne
    @JoinColumn(name = "cityid", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Street cityByCityid;

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

    public int getStreetid() {
        return streetid;
    }

    public void setStreetid(int streetid) {
        this.streetid = streetid;
    }

    public Street getStreetByStreetid() {
        return streetByStreetid;
    }

    public void setStreetByStreetid(Street streetByStreetid) {
        this.streetByStreetid = streetByStreetid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public Street getCityByCityid() {
        return cityByCityid;
    }

    public void setCityByCityid(Street cityByStreetid) {
        this.cityByCityid = cityByCityid;
    }

    public String getNumberSuffix() {
        return numberSuffix;
    }

    public void setNumberSuffix(String numberSuffix) {
        this.numberSuffix = numberSuffix;
    }
}
