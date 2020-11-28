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
@Table(name = "credit_card", schema = "givemeacar", catalog = "")
public class CreditCard {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = false, length = 16)
    private String number;
    @Column(name = "expiration_month", nullable = false)
    private int expirationMonth;
    @Column(name = "expiration_year", nullable = false)
    private int expirationYear;
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Column(name = "society", nullable = true, length = 45)
    private String society;
}
