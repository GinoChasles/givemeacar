package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Rent;
import fr.givemeacar.app.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentService extends CrudServiceImpl<Rent>{
    @Autowired
    RentRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Rent> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Rent model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Rent model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
