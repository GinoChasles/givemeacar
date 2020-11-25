package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Energy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyRepository extends JpaRepository<Energy, Long> {
}