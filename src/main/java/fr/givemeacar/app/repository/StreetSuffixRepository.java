package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.StreetSuffix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StreetSuffixRepository extends JpaRepository<StreetSuffix, Integer> {

}
