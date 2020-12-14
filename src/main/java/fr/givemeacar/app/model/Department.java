package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "departments", schema = "givemeacar", catalog = "")
public class Department  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "code", nullable = true, length = 45)
    private String code;
    @OneToOne
    @JoinColumn(name = "regionid", referencedColumnName = "id",
            nullable = false, insertable = false,updatable = false)
    private Region region;

    @JoinColumn(name = "regionid", referencedColumnName = "id", nullable = false)
    private int regionId;

}
