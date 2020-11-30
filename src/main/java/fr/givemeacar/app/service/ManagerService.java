package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService extends CrudServiceImpl<Manager>{
    @Autowired
    ManagerRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Manager> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Manager model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Manager model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
