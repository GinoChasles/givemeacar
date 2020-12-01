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
    @Column(name = "regionid", nullable = false)
    private int regionid;
    @OneToOne
    @JoinColumn(name = "regionid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Region regionByRegionid;

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

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public Region getRegionByRegionid() {
        return regionByRegionid;
    }

    public void setRegionByRegionid(Region regionByRegionid) {
        this.regionByRegionid = regionByRegionid;
    }
}
