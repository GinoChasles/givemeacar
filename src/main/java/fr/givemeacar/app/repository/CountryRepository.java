package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CountryRepository extends JpaRepository<Country, Integer> {

}
