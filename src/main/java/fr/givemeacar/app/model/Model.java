package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "models", schema = "givemeacar", catalog = "")
public class Model implements CrudModel {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToOne
    @JoinColumn(name = "brandid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Brand brand;

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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brandByBrandId) {
        this.brand = brand;
    }
}
