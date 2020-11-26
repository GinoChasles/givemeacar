package fr.givemeacar.app.model;

import javax.persistence.*;

@Entity
public class Address {
    private int id;
    private int number;
    private String localities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 45)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "localities", nullable = true, length = 45)
    public String getLocalities() {
        return localities;
    }

    public void setLocalities(String localities) {
        this.localities = localities;
    }

}
