package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.EnergyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyTypeRepository extends JpaRepository<EnergyType, Long> {
}