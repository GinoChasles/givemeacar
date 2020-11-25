package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Street {
    private int id;
    private String name;
    private int streetTypeId;
    private Collection<Address> addressesById;
    private StreetType streetTypeByStreetTypeId;
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
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "street_type_id", nullable = false)
    public int getStreetTypeId() {
        return streetTypeId;
    }

    public void setStreetTypeId(int streetTypeId) {
        this.streetTypeId = streetTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Street street = (Street) o;

        if (id != street.id) return false;
        if (streetTypeId != street.streetTypeId) return false;
        if (name != null ? !name.equals(street.name) : street.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + streetTypeId;
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
    @JoinColumn(name = "street_type_id", referencedColumnName = "id", nullable = false)
    public StreetType getStreetTypeByStreetTypeId() {
        return streetTypeByStreetTypeId;
    }

    public void setStreetTypeByStreetTypeId(StreetType streetTypeByStreetTypeId) {
        this.streetTypeByStreetTypeId = streetTypeByStreetTypeId;
    }

    @OneToMany(mappedBy = "streetByStreetId")
    public Collection<StreetHasCity> getStreetHasCitiesById() {
        return streetHasCitiesById;
    }

    public void setStreetHasCitiesById(Collection<StreetHasCity> streetHasCitiesById) {
        this.streetHasCitiesById = streetHasCitiesById;
    }
}
