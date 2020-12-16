package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.model.City;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface AgencyRepository extends findByNameStartingWithRepository<Agency>,
        BaseCrudRepository<Agency> {


}