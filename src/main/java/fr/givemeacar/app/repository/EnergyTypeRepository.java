package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.EnergyType;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyTypeRepository extends
        BaseCrudRepository<EnergyType> {

}