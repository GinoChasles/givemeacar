package fr.givemeacar.app.service;

import fr.givemeacar.app.repository.BaseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import fr.givemeacar.app.model.CrudModel;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public abstract class CrudServiceImpl<T> implements CrudService<T> {

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

    public T findById(int id){
        return (T)((BaseCrudRepository)getRepository()).findById(id);
    }

    public List<T> findAll(int offset, int limit, String order, String sort) {

        return ((BaseCrudRepository)getRepository()).findAll(
                PageRequest.of((int) Math.floor(offset / (limit-offset)),
                        limit-offset,
                        "DESC".equals(order) ? Sort.by(sort).descending() : Sort.by(sort).ascending()
                )
        ).toList();
    }
}