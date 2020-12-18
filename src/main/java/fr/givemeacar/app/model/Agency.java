package fr.givemeacar.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "agencies", schema = "givemeacar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agency implements CrudModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    @Pattern(regexp = "[a-zA-Z" +
            "àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,32}")
    private String name;


    /* Address */

    @Column(name = "address_id", nullable = false)
    private int address_id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "address_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    private Address address;

    public String getFullAddress() {
        return getAddress().getNumber() + " " + getAddress().getStreet().getName() + " " +
                getAddress().getSuffix() + " " + getAddress().getZipCode() + " - " +
                getAddress().getCity().getName();
    }

    /* Manager */

    @Column(name = "manager_id", nullable = false)
    private int manager_id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false, updatable = false, insertable =
            false)
    private Manager manager;

    public String getManagerFullName() {
        if (getManager() != null) {
            return getManager().getFirstName() + ' ' + getManager().getLastName();
        }
        return null;
    }
}
