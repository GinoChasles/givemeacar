package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
