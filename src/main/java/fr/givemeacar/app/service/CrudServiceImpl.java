package fr.givemeacar.app.service;

import fr.givemeacar.app.repository.BaseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.givemeacar.app.model.CrudModel;

import java.util.List;
import java.util.Optional;

@Service
public abstract class CrudServiceImpl<T> implements CrudService<T> {

    @Autowired
    BaseCrudRepository<T> repository;

    public Long count(){
        return getRepository().countById();
    }

    public T create(T model) { return (T) getRepository().save(model); }

    public T update(T model) { return getRepository().existsById(((CrudModel)model).getId()) ? getRepository().save(model) : null; }

    public T deleteById(int id){
        return getRepository().deleteById(id);
    }

    public T findLast(){
        return getRepository().findFirstByOrderByIdDesc();
    }

    public T findById(int id){
        return getRepository().findById(id);
    }

    public List<T> findAll(int offset, int limit, String order, String sort) {

        return getRepository().findAll(
                PageRequest.of((int) Math.floor(offset / (limit-offset)),
                        limit-offset,
                        "ASC".equals(order) ? Sort.by(sort).ascending() : Sort.by(sort).descending()
                )
        ).toList();
    }

    public BaseCrudRepository<T> getRepository() {
        return repository;
    }
}
