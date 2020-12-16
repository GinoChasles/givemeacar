package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.model.Color;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ColorRepository extends findByNameStartingWithRepository<Color>, BaseCrudRepository<Color> {
}
