package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "client", schema = "givemeacar", catalog = "")
public class Client {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;
    @Column(name = "mail", nullable = false, length = 64)
    private String mail;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "phone", nullable = false, length = 12)
    private String phone;
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Column(name = "user_status_id", nullable = false)
    private int userStatusId;
    @Column(name = "bill_id", nullable = false)
    private int billId;
    @Column(name = "credit_card_id", nullable = false)
    private int creditCardId;
    @Column(name = "agency_id", nullable = false)
    private int agencyId;
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Agency agencyByAgencyId;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address addressByAddressId;
    @OneToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private UserStatus userStatusByUserStatusId;
    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Bill billByBillId;
    @OneToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private CreditCard creditCardByCreditCardId;
    @OneToMany(mappedBy = "clientByClientId")
    private Collection<Rent> rentsById;
}
