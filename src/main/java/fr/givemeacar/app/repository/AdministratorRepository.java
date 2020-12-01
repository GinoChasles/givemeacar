package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

}
