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
    @Column(name = "addressid", nullable = false)
    private int addressid;
    @Column(name = "userstatusid", nullable = false)
    private int userStatusid;
    @Column(name = "billid", nullable = false)
    private int billid;
    @Column(name = "creditCardid", nullable = false)
    private int creditCardid;
    @Column(name = "agencyid", nullable = false)
    private int agencyid;
    @OneToOne
    @JoinColumn(name = "agencyid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Agency agencyByAgencyid;
    @OneToOne
    @JoinColumn(name = "addressid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Address addressByAddressid;
    @OneToOne
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private UserStatus userStatusByUserStatusid;
    @OneToOne
    @JoinColumn(name = "billid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Bill billByBillid;
    @OneToOne
    @JoinColumn(name = "creditCardid", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private CreditCard creditCardByCreditCardid;
    @OneToMany(mappedBy = "clientByClientid")
    private Collection<Rent> rentsByid;

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

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public int getUserStatusid() {
        return userStatusid;
    }

    public void setUserStatusid(int userStatusid) {
        this.userStatusid = userStatusid;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public int getCreditCardid() {
        return creditCardid;
    }

    public void setCreditCardid(int creditCardid) {
        this.creditCardid = creditCardid;
    }

    public int getAgencyid() {
        return agencyid;
    }

    public void setAgencyid(int agencyid) {
        this.agencyid = agencyid;
    }

    public Agency getAgencyByAgencyid() {
        return agencyByAgencyid;
    }

    public void setAgencyByAgencyid(Agency agencyByAgencyid) {
        this.agencyByAgencyid = agencyByAgencyid;
    }

    public Address getAddressByAddressid() {
        return addressByAddressid;
    }

    public void setAddressByAddressid(Address addressByAddressid) {
        this.addressByAddressid = addressByAddressid;
    }

    public UserStatus getUserStatusByUserStatusid() {
        return userStatusByUserStatusid;
    }

    public void setUserStatusByUserStatusid(UserStatus userStatusByUserStatusid) {
        this.userStatusByUserStatusid = userStatusByUserStatusid;
    }

    public Bill getBillByBillid() {
        return billByBillid;
    }

    public void setBillByBillid(Bill billByBillid) {
        this.billByBillid = billByBillid;
    }

    public CreditCard getCreditCardByCreditCardid() {
        return creditCardByCreditCardid;
    }

    public void setCreditCardByCreditCardid(CreditCard creditCardByCreditCardid) {
        this.creditCardByCreditCardid = creditCardByCreditCardid;
    }

    public Collection<Rent> getRentsByid() {
        return rentsByid;
    }

    public void setRentsByid(Collection<Rent> rentsByid) {
        this.rentsByid = rentsByid;
    }
}
