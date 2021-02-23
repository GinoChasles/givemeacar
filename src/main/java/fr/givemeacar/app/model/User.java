package fr.givemeacar.app.model;

import static java.util.stream.Collectors.joining;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Représentation des utilisateurs
 */
@Entity
@Table(name = "users", schema = "givemeacar")
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
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆŠŽ∂ð ,.'-]{2,32}")
    private String firstName;

    //le nom de famile de l'utilisateur
    @Column(name = "lastname", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆŠŽ∂ð ,.'-]{2,32}")
    private String lastName;

    //le nom d'utilisateur de l'utilisateur
    private String username;

    //l'email de l'utilisateur
    @Column(name = "mail", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\" +
            ".[a-zA-Z]{2,6}$")
    private String mail;

    //le mot de passe de l'utilisateur
    @Column(name = "password", length = 64)
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    //le numéro de téléphone de l'utilisateur
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "\\+?[0-9]{10,12}")
    private String phone;

    //le numéro de la rue de l'utilisateur
    @Column(name = "street_number")
    private Integer streetNumber;


    //le suffixe de la rue de l'utilisateur
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_suffix_id", referencedColumnName = "id", insertable = false,updatable = false)
    private StreetSuffix streetSuffix;

    //l'id du suffixe de la rue de l'utilisateur
    @Column(name = "street_suffix_id", nullable = false)
    private Integer street_suffix_id;

    //la rue de l'utilisateur
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", referencedColumnName = "id",  insertable = false,updatable = false)
    private Street street;

    //l'id de la rue de l'utilisateur
    @Column(name = "street_id", nullable = false)
    private Integer street_id;

    //la ville de l'utilisateur
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id",  insertable = false, updatable = false)
    private City city;

    //l'id de la ville de l'utilisateur
    @Column(name = "city_id", nullable = false)
    private Integer city_id;

    //#TODO ManyToMany sur user et bills
    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id",  updatable = false, insertable = false)
    private Bill bill;

    //la carte de crédit de l'utilisateur
    @OneToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id",  updatable = false,insertable = false)
    private CreditCard creditCard;

    //l'id de la carte de crédit de l'utilisateur
    @Column(name = "credit_card_id")
    private Integer credit_card_id;

    //l'agence rattachée à l'utilisateur
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false, updatable = false, insertable =
            false)
    private Agency agency;

    //l'id de l'agence rattachée à l'utilisateur
    @Column(name = "agency_id", nullable = false)
    private Integer agency_id;

    @OneToMany(mappedBy = "user")
    private Set<Rent> rents;

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public StreetSuffix getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(StreetSuffix streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public Integer getStreet_suffix_id() {
        return street_suffix_id;
    }

    public void setStreet_suffix_id(Integer street_suffix_id) {
        this.street_suffix_id = street_suffix_id;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Integer getStreet_id() {
        return street_id;
    }

    public void setStreet_id(Integer street_id) {
        this.street_id = street_id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Integer getCredit_card_id() {
        return credit_card_id;
    }

    public void setCredit_card_id(Integer credit_card_id) {
        this.credit_card_id = credit_card_id;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Integer getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(Integer agency_id) {
        this.agency_id = agency_id;
    }

    public void updateUsername(){
        username = Integer.toString(id);
    }

    public String getUsername(){
        return username;
    }

    public String getJoinedRoles(){
        return roles.stream().map(Role::getName).collect(joining(","));
    }

    public List<Integer> getRoleIds(){
        return roles.stream().map(Role::getId).collect(Collectors.toList());
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isEnabled() == user.isEnabled() &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getRoles(), user.getRoles()) &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getMail(), user.getMail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                Objects.equals(getStreetNumber(), user.getStreetNumber()) &&
                Objects.equals(getStreetSuffix(), user.getStreetSuffix()) &&
                Objects.equals(getStreet_suffix_id(), user.getStreet_suffix_id()) &&
                Objects.equals(getStreet(), user.getStreet()) &&
                Objects.equals(getStreet_id(), user.getStreet_id()) &&
                Objects.equals(getCity(), user.getCity()) &&
                Objects.equals(getCity_id(), user.getCity_id()) &&
                Objects.equals(getBill(), user.getBill()) &&
                Objects.equals(getCreditCard(), user.getCreditCard()) &&
                Objects.equals(getCredit_card_id(), user.getCredit_card_id()) &&
                Objects.equals(getAgency(), user.getAgency()) &&
                Objects.equals(getAgency_id(), user.getAgency_id()) &&
                Objects.equals(getRents(), user.getRents());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), isEnabled(), getRoles(), getFirstName(), getLastName(), getUsername(), getMail(),
                getPassword(), getPhone(), getStreetNumber(), getStreetSuffix(), getStreet_suffix_id(), getStreet(),
                getStreet_id(), getCity(), getCity_id(), getBill(), getCreditCard(), getCredit_card_id(), getAgency(),
                getAgency_id(), getRents());
    }
}
