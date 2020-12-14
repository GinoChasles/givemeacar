package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.EnergyType;

public interface EnergyTypeRepository extends findByNameStartingWithRepository<EnergyType>,
        BaseCrudRepository<EnergyType> {
}