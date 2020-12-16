package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.model.StreetSuffix;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface StreetSuffixRepository extends findByNameStartingWithRepository<StreetSuffix>,  BaseCrudRepository<StreetSuffix> {
}