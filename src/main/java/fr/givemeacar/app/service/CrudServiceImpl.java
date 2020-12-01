package fr.givemeacar.app.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
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
import java.util.Optional;

@Service
public class CrudServiceImpl<T> implements CrudService<T> {
    @PersistenceContext
    EntityManager em;

    public BigInteger count(String tableName) {
        Query q = getEntityManager().createNativeQuery("SELECT COUNT(*) FROM "+tableName);
        return (BigInteger) q.getSingleResult();
    }

    public Collection<T> findAll(String tableName,int offset, int limit){
        Query q = getEntityManager().createNativeQuery("SELECT * FROM "+tableName);
        return q.setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    @Transactional
    public Object findById(String tableName, T t, int id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        CrudModel model = (CrudModel) getEntityManager().find(t.getClass(),id);

        if (model != null) {
            try{
                return ResponseEntity.ok().body(model);
            }catch(Exception e){
                return exceptionToResponseEntity(e);
            }
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> create(JpaRepository<T, Integer> repo,T model) {
        try {
            repo.save(model);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> update(JpaRepository<T, Integer> repo,T model,int id) {
        Optional<T> optionalT = repo.findById(id);

        if (optionalT.isPresent()) {
            CrudModel oldT = (CrudModel)optionalT.get();
            ((CrudModel) model).setId(oldT.getId());
            return trySaveOrConflict(repo, model);
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    public ResponseEntity<String> delete(T t,int id) {
        T del = (T)getEntityManager().find(t.getClass(),id);

        if (del != null) {
            try {
                getEntityManager().remove(del);
                return ResponseEntity.ok().build();
            } catch (DataIntegrityViolationException e) {
                return exceptionToResponseEntity(e);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<String> exceptionToResponseEntity(Exception e) {
        String constraint = e.getMessage().split(";")[2].replace(" constraint [", "").replace("]", "");
        return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"" + constraint + "\"}");
    }

    public ResponseEntity<String> trySaveOrConflict(JpaRepository<T,Integer> repo,T model) {
        try {
            repo.save(model);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            return exceptionToResponseEntity(e);
        }
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
