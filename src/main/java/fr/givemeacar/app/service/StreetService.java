package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetService extends CrudServiceImpl<Street>{
    @Autowired
    StreetRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Street> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Street model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Street model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
