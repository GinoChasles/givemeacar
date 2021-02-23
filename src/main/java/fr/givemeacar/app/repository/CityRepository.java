package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository  extends BaseCrudRepository<City> {
}