package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Region;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends
        BaseCrudRepository<Region> {

}