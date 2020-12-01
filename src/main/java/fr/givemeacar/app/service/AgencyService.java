package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyService extends CrudServiceImpl<Agency>{
    @Autowired
    AgencyRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Agency> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Agency model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Agency model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
