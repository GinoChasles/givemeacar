package fr.givemeacar.app.service;

import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService extends CrudServiceImpl<CreditCard>{
    @Autowired
    CreditCardRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<CreditCard> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(CreditCard model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(CreditCard model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
