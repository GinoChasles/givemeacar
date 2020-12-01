package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "street_suffices", schema = "givemeacar", catalog = "")
public class StreetSuffix  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 12)
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
