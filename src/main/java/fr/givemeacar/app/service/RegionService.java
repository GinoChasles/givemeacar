package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Region;
import fr.givemeacar.app.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegionService extends CrudServiceImpl<Region>{
    @Autowired
    RegionRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Region> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Region model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Region model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
