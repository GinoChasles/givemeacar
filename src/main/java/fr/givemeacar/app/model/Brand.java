package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "brand", schema = "givemeacar", catalog = "")
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
<<<<<<< HEAD
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandByBrandId")
    private Collection<Model> modelsById;
=======
    @OneToMany(mappedBy = "brandByBrandId")
>>>>>>> vivien

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
}
