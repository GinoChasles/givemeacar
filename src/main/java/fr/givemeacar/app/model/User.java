package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * Représentation des utilisateurs
 */
@Data
@Entity
@Table(name = "users", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements CrudModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //l'activation de l'utilisateur
    private boolean enabled;

    //les rôles de l'utilisateur
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles;

    //le prénom de l'utilisateur
    @Column(name = "firstname", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String firstName;

    //le nom de famile de l'utilisateur
    @Column(name = "lastname", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String lastName;

    //le nom d'utilisateur de l'utilisateur
    private String username;

    //l'email de l'utilisateur
    @Column(name = "mail", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\" +
            ".[a-zA-Z]{2,6}$")
    private String mail;

    //le mot de passe de l'utilisateur
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    //le numéro de téléphone de l'utilisateur
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "\\+?[0-9]{10,12}")
    private String phone;

    //le numéro de la rue de l'utilisateur
    @Column(name = "street_number", nullable = true)
    private Integer streetNumber;


    //le suffixe de la rue de l'utilisateur
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_suffix_id", referencedColumnName = "id", nullable = true, insertable = false,
            updatable = false)
    private StreetSuffix streetSuffix;

    //l'id du suffixe de la rue de l'utilisateur
    @Column(name = "street_suffix_id", nullable = false)
    private Integer street_suffix_id;

    //la rue de l'utilisateur
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = true, insertable = false,
            updatable = false)
    private Street street;

    //l'id de la rue de l'utilisateur
    @Column(name = "street_id", nullable = false)
    private Integer street_id;

    //la ville de l'utilisateur
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    private City city;

    //l'id de la ville de l'utilisateur
    @Column(name = "city_id", nullable = false)
    private Integer city_id;

    //#TODO ManyToMany sur user et bills
    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = true, updatable = false, insertable = false)
    private Bill bill;

    //la carte de crédit de l'utilisateur
    @OneToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id", nullable = true, updatable = false,
            insertable = false)
    private CreditCard creditCard;

    //l'id de la carte de crédit de l'utilisateur
    @Column(name = "credit_card_id", nullable = true)
    private Integer credit_card_id;

    //l'agence rattachée à l'utilisateur
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false, updatable = false,
            insertable = false)
    private Agency agency;

    //l'id de l'agence rattachée à l'utilisateur
    @Column(name = "agency_id", nullable = false)
    private Integer agency_id;

    public void updateUsername(){
        username = Integer.toString(id);
    }

    public String getUsername(){
        return username;
    }

    public String getJoinedRoles(){
        return (String) roles.stream().map(role->role.getName()).collect(joining(","));
    }

    public List<Integer> getRoleIds(){
        return roles.stream().map(role->role.getId().intValue()).collect(Collectors.toList());
    }
}
