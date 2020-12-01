package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "agencies", schema = "givemeacar", catalog = "")
public class Agency {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Column(name = "manager_id", nullable = false)
    private int managerId;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address addressByAddressId;
    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Manager managerByManagerId;

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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    public Manager getManagerByManagerId() {
        return managerByManagerId;
    }

    public void setManagerByManagerId(Manager managerByManagerId) {
        this.managerByManagerId = managerByManagerId;
    }

}
