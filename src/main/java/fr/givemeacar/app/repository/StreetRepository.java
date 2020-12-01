package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StreetRepository extends JpaRepository<Street, Integer> {

}
