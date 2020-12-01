package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CityRepository extends JpaRepository<City, Integer> {

}
