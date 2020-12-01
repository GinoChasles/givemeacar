package fr.givemeacar.app.service;

import fr.givemeacar.app.model.City;
import fr.givemeacar.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService extends CrudServiceImpl<City>{
    @Autowired
    CityRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<City> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(City model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(City model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
