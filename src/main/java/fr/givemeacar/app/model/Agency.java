package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Agency {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Column(name = "client_id", nullable = false)
    private int clientId;
    @Column(name = "bill_id", nullable = false)
    private int billId;
    @Column(name = "manager_id", nullable = false)
    private int managerId;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address addressByAddressId;
    @OneToMany(mappedBy = "agencyByAgencyId")
    private Collection<Client> clientsById;
    @OneToMany(mappedBy = "agencyByAgencyId")
    private Collection<Client> billsById;
    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Manager managerByManagerId;
}
