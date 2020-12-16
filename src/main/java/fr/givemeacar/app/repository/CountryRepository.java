package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.model.Country;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface CountryRepository extends findByNameStartingWithRepository<Country>,
        BaseCrudRepository<Country> {

}