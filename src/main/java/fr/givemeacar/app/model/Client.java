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
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Agency agency;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Address address;
    @OneToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private UserStatus userStatus;
    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Bill bill;
    @OneToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private CreditCard creditCard;

    @Column(name = "agency_id", nullable = false)
    private int agency_id;
    @Column(name = "address_id", nullable = false)
    private int address_id;
    @Column(name = "user_status_id", nullable = false)
    private int user_status_id;
    @Column(name = "bill_id", nullable = false)
    private int bill_id;
    @Column(name = "credit_card_id", nullable = false)
    private int credit_card_id;
}
