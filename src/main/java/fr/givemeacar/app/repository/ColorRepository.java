package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Color;

public interface ColorRepository extends findByNameStartingWithRepository<Color>, BaseCrudRepository<Color> {
}
