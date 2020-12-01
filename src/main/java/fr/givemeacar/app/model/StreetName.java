package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "streetNames", schema = "givemeacar", catalog = "")
public class StreetName  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;

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
