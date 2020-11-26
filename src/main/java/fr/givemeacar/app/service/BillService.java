package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Service
public class BillService {
    @Autowired
    BillRepository repo;

    public Long count() {
        return repo.count();
    }

    public Optional<Bill> findById(int id) {

        System.out.println(id);
        return repo.findById(id);
    }

    public ResponseEntity<String> create(Bill model) {
        try {
            repo.save(model);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            String constraint = e.getMessage().split(";")[2].replace(" constraint [", "").replace("]", "");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"" + constraint + "\"}");
        }
    }

    public ResponseEntity<String> update(int id, Bill model) {
        Optional<Bill> optionalBill = repo.findById(id);
        Bill oldBill;

        if (optionalBill.isPresent()) {
            oldBill = optionalBill.get();
            model.setId(oldBill.getId());
            try {
                repo.save(model);
            } catch (DataIntegrityViolationException e) {
                String constraint = e.getMessage().split(";")[2].replace(" constraint [", "").replace("]", "");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"" + constraint + "\"}");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    public ResponseEntity<String> delete(int id) {
        if (repo.existsById(id)) {
            try {
                repo.deleteById(id);
                return ResponseEntity.ok().build();
            } catch (DataIntegrityViolationException e) {
                String constraint = e.getMessage().split(";")[2].replace(" constraint [", "").replace("]", "");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"" + constraint + "\"}");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
