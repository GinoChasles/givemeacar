package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorService extends CrudServiceImpl<Administrator>{
    @Autowired
    AdministratorRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Administrator> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Administrator model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Administrator model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
