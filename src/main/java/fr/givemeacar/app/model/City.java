package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class City {
    private int id;
    private String name;
    private String zipcode;
    private int countryId;
    private Collection<Address> addressesById;
    private Country countryByCountryId;
    private Collection<StreetHasCity> streetHasCitiesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 68)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "zipcode", nullable = false, length = 5)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "country_id", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (countryId != city.countryId) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (zipcode != null ? !zipcode.equals(city.zipcode) : city.zipcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + countryId;
        return result;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Address> getAddressesById() {
        return addressesById;
    }

    public void setAddressesById(Collection<Address> addressesById) {
        this.addressesById = addressesById;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<StreetHasCity> getStreetHasCitiesById() {
        return streetHasCitiesById;
    }

    public void setStreetHasCitiesById(Collection<StreetHasCity> streetHasCitiesById) {
        this.streetHasCitiesById = streetHasCitiesById;
    }
}
