package fr.givemeacar.app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Manager {
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private int userStatusId;
    private int agencyId;
    private Collection<Agency> agenciesById;
    private UserStatus userStatusByUserStatusId;
    private Agency agencyByAgencyId;

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
    @Column(name = "user_status_id", nullable = false)
    public int getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(int userStatusId) {
        this.userStatusId = userStatusId;
    }

    @Basic
    @Column(name = "agency_id", nullable = false)
    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (id != manager.id) return false;
        if (userStatusId != manager.userStatusId) return false;
        if (agencyId != manager.agencyId) return false;
        if (firstName != null ? !firstName.equals(manager.firstName) : manager.firstName != null) return false;
        if (lastName != null ? !lastName.equals(manager.lastName) : manager.lastName != null) return false;
        if (mail != null ? !mail.equals(manager.mail) : manager.mail != null) return false;
        if (password != null ? !password.equals(manager.password) : manager.password != null) return false;
        if (phone != null ? !phone.equals(manager.phone) : manager.phone != null) return false;

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
        result = 31 * result + userStatusId;
        result = 31 * result + agencyId;
        return result;
    }

    @OneToMany(mappedBy = "managerByManagerId")
    public Collection<Agency> getAgenciesById() {
        return agenciesById;
    }

    public void setAgenciesById(Collection<Agency> agenciesById) {
        this.agenciesById = agenciesById;
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
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false)
    public Agency getAgencyByAgencyId() {
        return agencyByAgencyId;
    }

    public void setAgencyByAgencyId(Agency agencyByAgencyId) {
        this.agencyByAgencyId = agencyByAgencyId;
    }
}
