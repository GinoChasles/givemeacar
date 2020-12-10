package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "managers", schema = "givemeacar")
public class Manager  implements CrudModel{
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
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false)
    private UserStatus userStatus;

    @Column(name = "agencyid", nullable = false)
    private int agencyId;
    @OneToOne
    @JoinColumn( name = "agencyid", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Agency agency;

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

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }
}
