package fr.givemeacar.app.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StreetHasCityPK implements Serializable {
    private int streetId;
    private int cityId;

    @Column(name = "street_id", nullable = false)
    @Id
    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    @Column(name = "city_id", nullable = false)
    @Id
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

        StreetHasCityPK that = (StreetHasCityPK) o;

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
}
