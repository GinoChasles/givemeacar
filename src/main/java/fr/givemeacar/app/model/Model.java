package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "models", schema = "givemeacar", catalog = "")
public class Model implements CrudModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToOne
    @JoinColumn(name = "brandid", referencedColumnName = "id",
            nullable = false,insertable = false,updatable = false)
    private Brand brand;
    @JoinColumn(name = "brandid", referencedColumnName = "id", nullable = false)
    private int brandById;
}
