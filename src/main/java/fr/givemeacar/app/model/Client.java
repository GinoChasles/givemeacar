package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Data
@Entity
@Table(name = "clients", schema = "givemeacar", catalog = "")
public class Client  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "firstname", nullable = false, length = 32)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 32)
    private String lastName;
    @Column(name = "mail", nullable = false, length = 64)
    private String mail;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @OneToOne
    @JoinColumn(name = "agencyid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Agency agency;
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Address address;
    @OneToOne
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false)
    private UserStatus userStatus;
    @OneToOne
    @JoinColumn(name = "billid", referencedColumnName = "id", nullable = false)
    private Bill bill;
    @OneToOne
    @JoinColumn(name = "creditcardid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private CreditCard creditCard;
}
