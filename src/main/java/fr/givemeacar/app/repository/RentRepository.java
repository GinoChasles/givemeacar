package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RentRepository extends JpaRepository<Rent, Integer> {

}
