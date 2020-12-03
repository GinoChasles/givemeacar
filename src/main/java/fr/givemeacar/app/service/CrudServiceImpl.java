package fr.givemeacar.app.service;

import fr.givemeacar.app.repository.AddressRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.givemeacar.app.model.CrudModel;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public abstract class CrudServiceImpl<T> implements CrudService<T> {

    public Long count() {
        return getRepository().count();
    }

    public List<T> findAll(int offset, int limit, String order, String sort) {
        Sort s = Sort.by(sort);
        System.out.println(limit-offset);
        return getRepository().findAll(
                PageRequest.of((int) Math.floor(offset / (limit-offset)),
                        limit-offset,
                        "ASC".equals(order) ? s.ascending() : s.descending()
                )
        ).toList();
    }

    public Optional<T> findById(int id) {
        return getRepository().findById(id);
    }

    public T create(T model) {
        T n = getRepository().save(model);
        System.out.println(n);
        return (T) getRepository().save(model);
    }

    public T update(T model, int id) {
        Optional<T> optionalT = getRepository().findById(id);

        if (optionalT.isPresent()) {
            CrudModel oldT = (CrudModel) optionalT.get();
            ((CrudModel) model).setId(oldT.getId());
            return (T) getRepository().save(model);
        }
        return null;
    }

    public boolean delete(int id) {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }

}
