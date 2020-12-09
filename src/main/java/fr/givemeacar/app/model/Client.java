package fr.givemeacar.app.model;



import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "clients", schema = "givemeacar", catalog = "")
public class Client  implements CrudModel{
    @Id
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
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private UserStatus userStatus;
    @OneToOne
    @JoinColumn(name = "billid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Bill bill;
    @OneToOne
    @JoinColumn(name = "creditcardid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private CreditCard creditCard;
    /**
    @OneToMany(mappedBy = "client")
    private Collection<Rent> rents;
    **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agencyByAgencyId) {
        this.agency = agency;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressByAddressId) {
        this.address = address;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatusByUserStatusId) {
        this.userStatus = userStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill billByBillId) {
        this.bill = bill;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCardByCreditCardId) {
        this.creditCard = creditCard;
    }
    /**
    public Collection<Rent> getRents() {
        return rents;
    }

    public void setRents(Collection<Rent> rentsById) {
        this.rents = rents;
    }
     **/
}
