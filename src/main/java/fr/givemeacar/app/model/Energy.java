package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Energy {
    private int id;
    private byte max;
    private byte current;
    private int energyTypeId;
    private Collection<Car> carsById;
    private EnergyType energyTypeByEnergyTypeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "max", nullable = false)
    public byte getMax() {
        return max;
    }

    public void setMax(byte max) {
        this.max = max;
    }

    @Basic
    @Column(name = "current", nullable = false)
    public byte getCurrent() {
        return current;
    }

    public void setCurrent(byte current) {
        this.current = current;
    }

    @Basic
    @Column(name = "energy_type_id", nullable = false)
    public int getEnergyTypeId() {
        return energyTypeId;
    }

    public void setEnergyTypeId(int energyTypeId) {
        this.energyTypeId = energyTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Energy energy = (Energy) o;

        if (id != energy.id) return false;
        if (max != energy.max) return false;
        if (current != energy.current) return false;
        if (energyTypeId != energy.energyTypeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) max;
        result = 31 * result + (int) current;
        result = 31 * result + energyTypeId;
        return result;
    }

    @OneToMany(mappedBy = "energyByEnergyId")
    public Collection<Car> getCarsById() {
        return carsById;
    }

    public void setCarsById(Collection<Car> carsById) {
        this.carsById = carsById;
    }

    @ManyToOne
    @JoinColumn(name = "energy_type_id", referencedColumnName = "id", nullable = false)
    public EnergyType getEnergyTypeByEnergyTypeId() {
        return energyTypeByEnergyTypeId;
    }

    public void setEnergyTypeByEnergyTypeId(EnergyType energyTypeByEnergyTypeId) {
        this.energyTypeByEnergyTypeId = energyTypeByEnergyTypeId;
    }
}
