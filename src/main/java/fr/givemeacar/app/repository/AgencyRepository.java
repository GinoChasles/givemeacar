package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AgencyRepository extends JpaRepository<Agency, Integer> {

}
