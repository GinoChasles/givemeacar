package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "managers", schema = "givemeacar")
public class Manager  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "firstname", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String firstName;
    @Column(name = "lastname", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,42}")
    private String lastName;
    @Column(name = "mail", nullable = false)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String mail;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "[0-9]{10}")
    private String phone;

    @OneToOne
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false, insertable = false,updatable = false)
    private UserStatus userStatus;
    @JoinColumn(name = "userstatusid", referencedColumnName = "id", nullable = false)
    private int userStatusById;

    @Column(name = "agencyid", nullable = false)
    private int agencyById;
    @OneToOne
    @JoinColumn( name = "agencyid", referencedColumnName = "id",
            nullable = false, insertable = false,updatable = false)
    private Agency agency;
}
