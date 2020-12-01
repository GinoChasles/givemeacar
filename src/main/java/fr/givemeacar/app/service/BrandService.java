package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService extends CrudServiceImpl<Brand>{
    @Autowired
    BrandRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Brand> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Brand model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Brand model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
