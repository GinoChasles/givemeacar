package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private int addressId;
    private int userStatusId;
    private int billId;
    private int agencyId;
    private int creditCardId;
    private Collection<Agency> agenciesById;
    private Address addressByAddressId;
    private UserStatus userStatusByUserStatusId;
    private Bill billByBillId;
    private Agency agencyByAgencyId;
    private CreditCard creditCardByCreditCardId;
    private Collection<Rent> rentsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName", nullable = false, length = 32)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 32)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 64)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address_id", nullable = false)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "user_status_id", nullable = false)
    public int getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(int userStatusId) {
        this.userStatusId = userStatusId;
    }

    @Basic
    @Column(name = "bill_id", nullable = false)
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Basic
    @Column(name = "agency_id", nullable = false)
    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Basic
    @Column(name = "credit_card_id", nullable = false)
    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (addressId != client.addressId) return false;
        if (userStatusId != client.userStatusId) return false;
        if (billId != client.billId) return false;
        if (agencyId != client.agencyId) return false;
        if (creditCardId != client.creditCardId) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (mail != null ? !mail.equals(client.mail) : client.mail != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + addressId;
        result = 31 * result + userStatusId;
        result = 31 * result + billId;
        result = 31 * result + agencyId;
        result = 31 * result + creditCardId;
        return result;
    }

    @OneToMany(mappedBy = "clientByClientId1")
    public Collection<Agency> getAgenciesById() {
        return agenciesById;
    }

    public void setAgenciesById(Collection<Agency> agenciesById) {
        this.agenciesById = agenciesById;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id", nullable = false)
    public UserStatus getUserStatusByUserStatusId() {
        return userStatusByUserStatusId;
    }

    public void setUserStatusByUserStatusId(UserStatus userStatusByUserStatusId) {
        this.userStatusByUserStatusId = userStatusByUserStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false)
    public Bill getBillByBillId() {
        return billByBillId;
    }

    public void setBillByBillId(Bill billByBillId) {
        this.billByBillId = billByBillId;
    }

    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false)
    public Agency getAgencyByAgencyId() {
        return agencyByAgencyId;
    }

    public void setAgencyByAgencyId(Agency agencyByAgencyId) {
        this.agencyByAgencyId = agencyByAgencyId;
    }

    @ManyToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id", nullable = false)
    public CreditCard getCreditCardByCreditCardId() {
        return creditCardByCreditCardId;
    }

    public void setCreditCardByCreditCardId(CreditCard creditCardByCreditCardId) {
        this.creditCardByCreditCardId = creditCardByCreditCardId;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<Rent> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<Rent> rentsById) {
        this.rentsById = rentsById;
    }
}
