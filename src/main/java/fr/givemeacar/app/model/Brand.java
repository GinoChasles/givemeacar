package fr.givemeacar.app.model;



import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "brand", schema = "givemeacar", catalog = "")
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandByBrandId")
    private Collection<Model> modelsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Model> getModelsById() {
        return modelsById;
    }

    public void setModelsById(Collection<Model> modelsById) {
        this.modelsById = modelsById;
    }
}
