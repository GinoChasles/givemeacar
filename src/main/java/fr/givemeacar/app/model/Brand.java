package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand", schema = "givemeacar", catalog = "")
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToMany(mappedBy = "brandByBrandId")
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
