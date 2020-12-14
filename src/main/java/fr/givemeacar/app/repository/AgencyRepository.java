package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;

public interface AgencyRepository extends findByNameStartingWithRepository<Agency>,
        BaseCrudRepository<Agency> {
}