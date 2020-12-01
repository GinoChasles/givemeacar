package fr.givemeacar.app.model;



import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "cities", schema = "givemeacar", catalog = "")
public class City  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 68)
    private String name;
    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;
    @Column(name = "longitude", nullable = false, precision = 14)
    private BigDecimal longitude;
    @Column(name = "latitude", nullable = false, precision = 14)
    private BigDecimal latitude;
    @Column(name = "departmentid", nullable = false)
    private int departmentid;
    @OneToOne
    @JoinColumn(name = "departmentid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Department departmentByDepartmentid;

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public Department getDepartmentByDepartmentid() {
        return departmentByDepartmentid;
    }

    public void setDepartmentByDepartmentid(Department departmentByDepartmentid) {
        this.departmentByDepartmentid = departmentByDepartmentid;
    }
}
