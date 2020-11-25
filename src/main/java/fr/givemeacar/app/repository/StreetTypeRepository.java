package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.StreetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetTypeRepository extends JpaRepository<StreetType, Long> {
}