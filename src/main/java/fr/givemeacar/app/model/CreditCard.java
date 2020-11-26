package fr.givemeacar.app.model;

import javax.persistence.*;

@Entity
@Table(name = "credit_card", schema = "givemeacar2", catalog = "")
public class CreditCard {
    private int id;
    private String number;
    private int expirationMonth;
    private int expirationYear;
    private String firstName;
    private String lastName;
    private String society;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 16)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "expirationMonth", nullable = false)
    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Basic
    @Column(name = "expirationYear", nullable = false)
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    @Basic
    @Column(name ="first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name ="last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "society", nullable = true, length = 45)
    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (id != that.id) return false;
        if (expirationMonth != that.expirationMonth) return false;
        if (expirationYear != that.expirationYear) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (society != null ? !society.equals(that.society) : that.society != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + expirationMonth;
        result = 31 * result + expirationYear;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (society != null ? society.hashCode() : 0);
        return result;
    }
}
