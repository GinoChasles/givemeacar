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
public class Client implements CrudModel,HasAddress {
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


    /** Address */



    @Column(name = "street_number", nullable = true)
    private int streetNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "street_suffix_id", referencedColumnName = "id", nullable = true, insertable = false,
            updatable = false)
    private StreetSuffix streetSuffix;

    @Column(name = "street_suffix_id", nullable = false)
    private int street_suffix_id;

    /* Street */

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = true, insertable = false,
            updatable = false)
    private Street street;

    @Column(name = "street_id", nullable = false)
    private int street_id;

    /*  City  */

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    @JsonIgnore
    private City city;

    @Column(name = "city_id", nullable = false)
    private int city_id;

    @OneToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id", updatable = false, insertable = false)
    @JsonIgnore
    private UserStatus userStatus;

    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = true, updatable = false, insertable = false)
    @JsonIgnore
    private Bill bill;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id", nullable = true, updatable = false,
            insertable = false)
    private CreditCard creditCard;

    @Column(name = "user_status_id")
    private int user_status_id = 3;

    @Column(name = "bill_id", nullable = true)
    private Integer bill_id;

    @Column(name = "credit_card_id", nullable = true)
    private Integer credit_card_id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false, updatable = false,
            insertable = false)
    private Agency agency;

    @Column(name = "agency_id", nullable = false)
    private int agency_id;


    @Override public String getStreetSuffixName() {
        if (streetSuffix != null) {
            return streetSuffix.getName();
        }
        return null;
    }

    public String getStreetName() {
        if (street != null) {
            return street.getName();
        }
        return null;
    }

    public String getZipCode() {
        if (city != null) {
            return city.getZipcode();
        }
        return null;
    }

    public String getAgencyName() {
        if (agency != null) {
            return agency.getName();
        }
        return null;
    }

    public String getCreditCardCodes() {
        if (creditCard != null) {
            return creditCard.getNumber();
        }
        return null;
    }

    public String getCityName() {
        if (city != null) {
            return city.getName();
        }
        return null;
    }

    public String getAddress(){
        if(streetNumber != 0 && streetSuffix != null && street != null && city != null){
            return streetNumber + " " + streetSuffix.getName() + " " + street.getName() + " - " + getZipCode() + " " + city.getName();
        }
        return null;
    }
}
