package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.model.StreetSuffix;

public interface StreetSuffixRepository extends findByNameStartingWithRepository<StreetSuffix>,  BaseCrudRepository<StreetSuffix> {
}