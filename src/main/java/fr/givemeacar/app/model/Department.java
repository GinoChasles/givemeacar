package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "departments", schema = "givemeacar", catalog = "")
public class Department  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "code", nullable = true, length = 45)
    private String code;
    @OneToOne
    @JoinColumn(name = "regionid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Region region;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region regionByRegionId) {
        this.region = region;
    }
}
