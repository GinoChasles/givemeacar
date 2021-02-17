package fr.givemeacar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface pour le Repository d'opération CRUD générique
 * @param <CrudModel> le modèle à manipuler par le répository
 */
@NoRepositoryBean
public interface BaseCrudRepository<CrudModel> extends CrudRepository<CrudModel>, JpaRepository<CrudModel,Integer> {
}
