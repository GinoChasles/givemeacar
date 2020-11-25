package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Brand {
    private int id;
    private String name;
    private int modelId;
    private Model modelByModelId;
    private Collection<Model> modelsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "model_id", nullable = false)
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (id != brand.id) return false;
        if (modelId != brand.modelId) return false;
        if (name != null ? !name.equals(brand.name) : brand.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + modelId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    public Model getModelByModelId() {
        return modelByModelId;
    }

    public void setModelByModelId(Model modelByModelId) {
        this.modelByModelId = modelByModelId;
    }

    @OneToMany(mappedBy = "brandByBrandId")
    public Collection<Model> getModelsById() {
        return modelsById;
    }

    public void setModelsById(Collection<Model> modelsById) {
        this.modelsById = modelsById;
    }
}
