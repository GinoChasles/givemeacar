package fr.givemeacar.app.model;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "credit_cards", schema = "givemeacar", catalog = "")
public class CreditCard  implements CrudModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = false, length = 16)
    private String number;
    @Column(name = "expirationmonth", nullable = false)
    private int expirationMonth;
    @Column(name = "expirationyear", nullable = false)
    private int expirationYear;
    @Column(name = "firstname", nullable = false, length = 45)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 45)
    private String lastName;
    @Column(name = "society", nullable = true, length = 45)
    private String society;

}
