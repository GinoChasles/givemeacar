package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Street {
    private int id;
    private int cityId;
    private int streetNameId;
    private Collection<Address> addressesById;
    private City cityByCityId;
    private StreetName streetNameByStreetNameId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name = "city_id", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    
    @Column(name = "street_name_id", nullable = false)
    public int getStreetNameId() {
        return streetNameId;
    }

    public void setStreetNameId(int streetNameId) {
        this.streetNameId = streetNameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Street street = (Street) o;

        if (id != street.id) return false;
        if (cityId != street.cityId) return false;
        if (streetNameId != street.streetNameId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cityId;
        result = 31 * result + streetNameId;
        return result;
    }

    @OneToMany(mappedBy = "streetByStreetId")
    public Collection<Address> getAddressesById() {
        return addressesById;
    }

    public void setAddressesById(Collection<Address> addressesById) {
        this.addressesById = addressesById;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "street_name_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    public StreetName getStreetNameByStreetNameId() {
        return streetNameByStreetNameId;
    }

    public void setStreetNameByStreetNameId(StreetName streetNameByStreetNameId) {
        this.streetNameByStreetNameId = streetNameByStreetNameId;
    }
}
