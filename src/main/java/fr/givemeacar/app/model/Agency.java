package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "agencies", schema = "givemeacar", catalog = "")
public class Agency  implements CrudModel{
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Column(name = "addressid", nullable = false)
    private int addressid;
    @Column(name = "managerid", nullable = false)
    private int managerid;
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address addressByAddressid;
    @OneToOne
    @JoinColumn(name = "managerid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Manager managerByManagerid;

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

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public int getManagerid() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }

    public Address getAddressByAddressid() {
        return addressByAddressid;
    }

    public void setAddressByAddressid(Address addressByAddressid) {
        this.addressByAddressid = addressByAddressid;
    }

    public Manager getManagerByManagerid() {
        return managerByManagerid;
    }

    public void setManagerByManagerid(Manager managerByManagerid) {
        this.managerByManagerid = managerByManagerid;
    }

}
