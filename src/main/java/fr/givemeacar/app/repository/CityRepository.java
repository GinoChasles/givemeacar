package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.model.City;
import fr.givemeacar.app.model.StreetSuffix;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface CityRepository  extends findByNameStartingWithRepository<City>,   BaseCrudRepository<City> {
}