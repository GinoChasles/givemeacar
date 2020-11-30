package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService extends CrudServiceImpl<Address>{
    @Autowired
    AddressRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Address> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Address model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Address model, int id) {
        return super.update(this.repo, model, id);
    }
    
    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
