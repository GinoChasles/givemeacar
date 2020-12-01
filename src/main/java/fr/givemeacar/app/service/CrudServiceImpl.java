package fr.givemeacar.app.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.givemeacar.app.model.CrudModel;

import java.util.Optional;

@Service
public abstract class CrudServiceImpl<T> implements CrudService<T> {

    public Long count(JpaRepository<T,Integer> repo) {
        return repo.count();
    }

    public Optional<T> findById(JpaRepository<T, Integer> repo,int id) {
        return repo.findById(id);
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
            trySaveOrConflict(repo, model);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> delete(JpaRepository<T, Integer> repo,int id) {
        if (repo.existsById(id)) {
            try {
                repo.deleteById(id);
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

}
