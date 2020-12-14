package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "managers", schema = "givemeacar")
public class Manager  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
}
