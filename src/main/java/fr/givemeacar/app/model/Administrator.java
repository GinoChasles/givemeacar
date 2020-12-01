package fr.givemeacar.app.model;



import javax.persistence.*;



@Entity
@Table(name = "administrator", schema = "givemeacar", catalog = "")
public class Administrator {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;
    @Column(name = "mail", nullable = false, length = 64)
    private String mail;
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Column(name = "phone", nullable = false, length = 12)
    private String phone;
    @Column(name = "user_status_id", nullable = false)
    private int userStatusId;
    @OneToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private UserStatus userStatusByUserStatusId;

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

    public int getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(int userStatusId) {
        this.userStatusId = userStatusId;
    }

    public UserStatus getUserStatusByUserStatusId() {
        return userStatusByUserStatusId;
    }

    public void setUserStatusByUserStatusId(UserStatus userStatusByUserStatusId) {
        this.userStatusByUserStatusId = userStatusByUserStatusId;
    }
}
