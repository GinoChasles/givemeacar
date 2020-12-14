package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Region;

public interface RegionRepository extends findByNameStartingWithRepository<Region>,
        BaseCrudRepository<Region> {

}