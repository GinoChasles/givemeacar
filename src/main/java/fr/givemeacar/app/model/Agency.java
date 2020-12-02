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
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address address;
    @OneToOne
    @JoinColumn(name = "managerid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Manager manager;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressByAddressId) {
        this.address = address;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager managerByManagerId) {
        this.manager = manager;
    }

}
