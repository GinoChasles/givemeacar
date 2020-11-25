package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Agency {
    private int id;
    private String name;
    private int managerId;
    private int clientId1;
    private int addressId;
    private int billId;
    private Manager managerByManagerId;
    private Client clientByClientId1;
    private Address addressByAddressId;
    private Bill billByBillId;
    private Collection<Bill> billsById;
    private Collection<Client> clientsById;
    private Collection<Manager> managersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "manager_id", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "client_id1", nullable = false)
    public int getClientId1() {
        return clientId1;
    }

    public void setClientId1(int clientId1) {
        this.clientId1 = clientId1;
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
    @Column(name = "bill_id", nullable = false)
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agency agency = (Agency) o;

        if (id != agency.id) return false;
        if (managerId != agency.managerId) return false;
        if (clientId1 != agency.clientId1) return false;
        if (addressId != agency.addressId) return false;
        if (billId != agency.billId) return false;
        if (name != null ? !name.equals(agency.name) : agency.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + managerId;
        result = 31 * result + clientId1;
        result = 31 * result + addressId;
        result = 31 * result + billId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    public Manager getManagerByManagerId() {
        return managerByManagerId;
    }

    public void setManagerByManagerId(Manager managerByManagerId) {
        this.managerByManagerId = managerByManagerId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id1", referencedColumnName = "id", nullable = false)
    public Client getClientByClientId1() {
        return clientByClientId1;
    }

    public void setClientByClientId1(Client clientByClientId1) {
        this.clientByClientId1 = clientByClientId1;
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
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false)
    public Bill getBillByBillId() {
        return billByBillId;
    }

    public void setBillByBillId(Bill billByBillId) {
        this.billByBillId = billByBillId;
    }

    @OneToMany(mappedBy = "agencyByAgencyId")
    public Collection<Bill> getBillsById() {
        return billsById;
    }

    public void setBillsById(Collection<Bill> billsById) {
        this.billsById = billsById;
    }

    @OneToMany(mappedBy = "agencyByAgencyId")
    public Collection<Client> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Collection<Client> clientsById) {
        this.clientsById = clientsById;
    }

    @OneToMany(mappedBy = "agencyByAgencyId")
    public Collection<Manager> getManagersById() {
        return managersById;
    }

    public void setManagersById(Collection<Manager> managersById) {
        this.managersById = managersById;
    }
}
