package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
