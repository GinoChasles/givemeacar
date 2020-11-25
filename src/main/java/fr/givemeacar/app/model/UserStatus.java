package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_status", schema = "givemeacar", catalog = "")
public class UserStatus {
    private int id;
    private String name;
    private Collection<Administrator> administratorsById;
    private Collection<Client> clientsById;
    private Collection<Manager> managersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
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

        UserStatus that = (UserStatus) o;

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

    @OneToMany(mappedBy = "userStatusByUserStatusId")
    public Collection<Administrator> getAdministratorsById() {
        return administratorsById;
    }

    public void setAdministratorsById(Collection<Administrator> administratorsById) {
        this.administratorsById = administratorsById;
    }

    @OneToMany(mappedBy = "userStatusByUserStatusId")
    public Collection<Client> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Collection<Client> clientsById) {
        this.clientsById = clientsById;
    }

    @OneToMany(mappedBy = "userStatusByUserStatusId")
    public Collection<Manager> getManagersById() {
        return managersById;
    }

    public void setManagersById(Collection<Manager> managersById) {
        this.managersById = managersById;
    }
}
