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
}
