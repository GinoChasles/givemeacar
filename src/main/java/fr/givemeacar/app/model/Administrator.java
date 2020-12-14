package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "administrators", schema = "givemeacar")
public class Administrator  implements CrudModel{
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
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String lastName;
    @Column(name = "mail", nullable = false)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String mail;
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Pattern(regexp = "[0-9]{10}")
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @OneToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id",
            nullable = false,updatable = false,insertable = false)
    private UserStatus userStatus;
    @Column(name = "user_status_id", nullable = false)
    private int user_status_id;
}
