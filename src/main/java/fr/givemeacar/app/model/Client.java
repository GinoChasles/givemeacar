package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;


@Data
@Entity
@Table(name = "clients", schema = "givemeacar", catalog = "")
public class Client  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "firstname", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String firstName;
    @Column(name = "lastname", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String lastName;
    @Column(name = "mail", nullable = false)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String mail;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "[0-9]{10}")
    private String phone;

    @OneToOne
    @JoinColumn(name = "agencyid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Agency agency;
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Address address;
    @OneToOne
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private UserStatus userStatus;
    @OneToOne
    @JoinColumn(name = "billid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Bill bill;
    @OneToOne
    @JoinColumn(name = "creditcardid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private CreditCard creditCard;

    @JoinColumn(name = "agencyid", referencedColumnName = "id", nullable = false)
    private int agencyId;
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false)
    private int addressId;
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false)
    private int userStatusId;
    @JoinColumn(name = "billid", referencedColumnName = "id", nullable = false)
    private int billId;
    @JoinColumn(name = "creditcardid", referencedColumnName = "id", nullable = false)
    private int creditCardId;
}
