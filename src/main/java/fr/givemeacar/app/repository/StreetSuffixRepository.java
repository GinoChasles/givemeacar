package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.StreetSuffix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetSuffixRepository extends JpaRepository<StreetSuffix, Integer> {

}
