package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {

}
