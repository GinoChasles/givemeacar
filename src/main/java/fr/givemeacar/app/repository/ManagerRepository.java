package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

}