package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Model;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends BaseCrudRepository<Model> {
}