package fr.givemeacar.app.model;



import javax.persistence.*;


@Entity
@Table(name = "credit_cards", schema = "givemeacar", catalog = "")
public class CreditCard  implements CrudModel{
    @Id
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }
}
