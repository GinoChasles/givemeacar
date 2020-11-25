package fr.givemeacar.app.model;

import javax.persistence.*;

@Entity
@Table(name = "street_has_city", schema = "givemeacar")
@IdClass(StreetHasCityPK.class)
public class StreetHasCity {
    private int streetId;
    private int cityId;
    private Street streetByStreetId;
    private City cityByCityId;

    @Id
    @Column(name = "street_id", nullable = false)
    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    @Id
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StreetHasCity that = (StreetHasCity) o;

        if (streetId != that.streetId) return false;
        if (cityId != that.cityId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = streetId;
        result = 31 * result + cityId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false)
    public Street getStreetByStreetId() {
        return streetByStreetId;
    }

    public void setStreetByStreetId(Street streetByStreetId) {
        this.streetByStreetId = streetByStreetId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}
