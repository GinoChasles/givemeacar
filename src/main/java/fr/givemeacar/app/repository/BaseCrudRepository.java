package fr.givemeacar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCrudRepository<CrudModel> extends CrudRepository<CrudModel>, JpaRepository<CrudModel,Integer> {
}
