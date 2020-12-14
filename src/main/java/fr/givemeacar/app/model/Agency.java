package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "agencies", schema = "givemeacar")
public class Agency  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false)
    private Address address;

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

}
