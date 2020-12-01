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
    @Column(name = "brandid", nullable = false)
    private int brandid;
    @OneToOne
    @JoinColumn(name = "brandid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Brand brandByBrandid;

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

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public Brand getBrandByBrandid() {
        return brandByBrandid;
    }

    public void setBrandByBrandid(Brand brandByBrandid) {
        this.brandByBrandid = brandByBrandid;
    }
}
