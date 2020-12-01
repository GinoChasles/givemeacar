package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ModelRepository extends JpaRepository<Model,Integer> {

}
