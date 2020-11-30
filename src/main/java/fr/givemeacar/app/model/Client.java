package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(int userStatusId) {
        this.userStatusId = userStatusId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public Agency getAgencyByAgencyId() {
        return agencyByAgencyId;
    }

    public void setAgencyByAgencyId(Agency agencyByAgencyId) {
        this.agencyByAgencyId = agencyByAgencyId;
    }

    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    public UserStatus getUserStatusByUserStatusId() {
        return userStatusByUserStatusId;
    }

    public void setUserStatusByUserStatusId(UserStatus userStatusByUserStatusId) {
        this.userStatusByUserStatusId = userStatusByUserStatusId;
    }

    public Bill getBillByBillId() {
        return billByBillId;
    }

    public void setBillByBillId(Bill billByBillId) {
        this.billByBillId = billByBillId;
    }

    public CreditCard getCreditCardByCreditCardId() {
        return creditCardByCreditCardId;
    }

    public void setCreditCardByCreditCardId(CreditCard creditCardByCreditCardId) {
        this.creditCardByCreditCardId = creditCardByCreditCardId;
    }

    public Collection<Rent> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<Rent> rentsById) {
        this.rentsById = rentsById;
    }
}
