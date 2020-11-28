package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "manager", schema = "givemeacar", catalog = "")
public class Manager {
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
    @Column(name = "user_status_id", nullable = false)
    private int userStatusId;
    @Column(name = "agency_id", nullable = false)
    private int agencyId;
    @OneToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private UserStatus userStatusByUserStatusId;
    @OneToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    private Agency agencyByAgencyId;
}
