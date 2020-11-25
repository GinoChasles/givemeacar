package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "energy_type", schema = "givemeacar")
public class EnergyType {
    private int id;
    private String name;
    private Collection<Energy> energyById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnergyType that = (EnergyType) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "energyTypeByEnergyTypeId")
    public Collection<Energy> getEnergyById() {
        return energyById;
    }

    public void setEnergyById(Collection<Energy> energyById) {
        this.energyById = energyById;
    }
}
