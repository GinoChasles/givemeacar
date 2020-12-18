package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "clients", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements CrudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\" +
            ".[a-zA-Z]{2,6}$")
    private String mail;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "\\+?[0-9]{10,12}")
    private String phone;


    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false, updatable = false,
            insertable = false)
    @JsonIgnore
    private Address address;
    @OneToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id", updatable = false, insertable = false)
    @JsonIgnore
    private UserStatus userStatus;
    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    @JsonIgnore
    private Bill bill;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id", nullable = false, updatable = false,
            insertable = false)
    private CreditCard creditCard;


    @Column(name = "address_id", nullable = false)
    private int address_id;
    @Column(name = "user_status_id")
    private int user_status_id = 3;
    @Column(name = "bill_id")
    private Integer bill_id;
    @Column(name = "credit_card_id", nullable = false)
    private Integer credit_card_id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false, updatable = false,
            insertable = false)
    private Agency agency;

    @Column(name = "agency_id", nullable = false)
    private int agency_id;

    public String getAgencyName() {
        if (getAgency() != null) {
            return getAgency().getName();
        }
        return null;
    }

    public String getCreditCardCodes() {
        if (getCreditCard() != null) {
            return getCreditCard().getNumber();
        }
        return null;
    }

    public String getCity() {
        if (getAddress() != null) {
            if (getAddress().getCity() != null) {
                return getAddress().getCity().getName();
            }
        }
        return null;
    }
}
