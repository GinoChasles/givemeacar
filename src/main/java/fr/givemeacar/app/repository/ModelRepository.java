package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Model;
import org.springframework.http.ResponseEntity;


public interface ModelRepository extends findByNameStartingWithRepository<Model>, BaseCrudRepository<Model> {
    ResponseEntity<Model> findByBrand_id(int id);
}