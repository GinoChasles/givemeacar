package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "street_name", schema = "givemeacar", catalog = "")
public class StreetName {
    private int id;
    private String name;
    private Collection<Street> streetsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name = "name", nullable = false, length = 45)
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

        StreetName that = (StreetName) o;

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

    @OneToMany(mappedBy = "streetNameByStreetNameId")
    public Collection<Street> getStreetsById() {
        return streetsById;
    }

    public void setStreetsById(Collection<Street> streetsById) {
        this.streetsById = streetsById;
    }
}
