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

@NoRepositoryBean
public class CrudServiceImpl<T> implements CrudService<T> {

    @Autowired
    EntityManager entityManager;

    public Long count() {
        return ((BaseCrudRepository)getRepository()).count();
    }

    public T create(T model) {
            return (T) getRepository().save(model);
    }

    public T update(T model) {
        return ((BaseCrudRepository)getRepository()).existsById(((CrudModel) model).getId()) ? (T)((BaseCrudRepository)getRepository()).save(model) : null;
    }

    public T deleteById(int id){
        return (T)((BaseCrudRepository)getRepository()).deleteById(id);
    }

    public T findLast(){
        return (T)((BaseCrudRepository)getRepository()).findFirstByOrderByIdDesc();
    }

    public Optional<T> findById(int id){
        return (Optional<T>)((BaseCrudRepository)getRepository()).findById(id);
    }

    public List<T> findAll(int offset, int limit, String order, String sort) {

        return ((BaseCrudRepository)getRepository()).findAll(
                PageRequest.of((int) Math.floor(offset / (limit-offset)),
                        limit-offset,
                        "DESC".equals(order) ? Sort.by(sort).descending() : Sort.by(sort).ascending()
                )
        ).toList();
    }

    public List<T> findByNameStartingWith(T clazz,String column,String name,String sort,String order,int offset,
                                          int limit){
        Query q = getEntityManager().createNativeQuery("SELECT * FROM " + column + " WHERE name LIKE '" + name +
                "%' " +
                "ORDER BY " + sort,clazz.getClass());

        return q.setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public BaseCrudRepository getRepository(){
        return null;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}