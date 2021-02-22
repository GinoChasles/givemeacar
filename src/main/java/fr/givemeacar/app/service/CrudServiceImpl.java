package fr.givemeacar.app.service;

import fr.givemeacar.app.repository.BaseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.repository.NoRepositoryBean;

import fr.givemeacar.app.model.CrudModel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Classe abstraite pour chaque service effectuant des opérations CRUD de base.
 * @param <T>
 */
@NoRepositoryBean
public abstract class CrudServiceImpl<T> implements CrudService<T> {

    /**
     * L'entityManager permettant d'effectuer des requêtes natives
     */
    @Autowired
    EntityManager entityManager;

    public Long count() {
        return getRepository().count();
    }

    public T create(T model) {
        return getRepository().save(model);
    }

    public T update(T model) {
        if(getRepository().existsById(((CrudModel) model).getId())) {
            return getRepository().save(model);
        }
        return null;
    }

    public Boolean deleteById(Integer id){
        getRepository().deleteById(id);
        return true;
    }

    public T findLast(){
        return getRepository().findFirstByOrderByIdDesc();
    }

    public Optional<T> findById(Integer id){
        return getRepository().findById(id);
    }

    public List<T> findAll(int offset, int limit, String order, String sort) {
        return getRepository().findAll(
                PageRequest.of((int) Math.floor(offset / (limit-offset)),
                        limit-offset,
                        "DESC".equals(order) ? Sort.by(sort).descending() : Sort.by(sort).ascending()
                )
        ).toList();
    }

    public List<T> findByNameLike(T clazz,String column,String name,String sort,String order,int offset,
                                          int limit){
        Query q =
                getEntityManager().createNativeQuery("SELECT * FROM " + column + " WHERE LOWER(name) LIKE \"%" + name +
                "%\" " +
                "ORDER BY " + sort,clazz.getClass());

        return q.setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public BaseCrudRepository<T> getRepository(){
        return null;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}