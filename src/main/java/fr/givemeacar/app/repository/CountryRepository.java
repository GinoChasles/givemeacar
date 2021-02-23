package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends
        BaseCrudRepository<Country> {

}