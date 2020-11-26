package fr.givemeacar.app.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
    private int id;
    private Integer number;
    private String localities;
    private int streetId;
    private int cityId;
    private int streetSuffixId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "localities", nullable = true, length = 64)
    public String getLocalities() {
        return localities;
    }

    public void setLocalities(String localities) {
        this.localities = localities;
    }

    @Basic
    @Column(name = "street_id", nullable = false)
    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    @Basic
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "street_suffix_id", nullable = false)
    public int getStreetSuffixId() {
        return streetSuffixId;
    }

    public void setStreetSuffixId(int streetSuffixId) {
        this.streetSuffixId = streetSuffixId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (streetId != address.streetId) return false;
        if (cityId != address.cityId) return false;
        if (streetSuffixId != address.streetSuffixId) return false;
        if (number != null ? !number.equals(address.number) : address.number != null) return false;
        if (localities != null ? !localities.equals(address.localities) : address.localities != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (localities != null ? localities.hashCode() : 0);
        result = 31 * result + streetId;
        result = 31 * result + cityId;
        result = 31 * result + streetSuffixId;
        return result;
    }
}
