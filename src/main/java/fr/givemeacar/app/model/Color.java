package fr.givemeacar.app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "color", schema = "givemeacar", catalog = "")
public class Color {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
}
