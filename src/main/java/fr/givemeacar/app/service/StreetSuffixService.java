package fr.givemeacar.app.service;

import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.repository.StreetSuffixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetSuffixService extends CrudServiceImpl<StreetSuffix>{
    @Autowired
    StreetSuffixRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<StreetSuffix> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(StreetSuffix model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(StreetSuffix model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
