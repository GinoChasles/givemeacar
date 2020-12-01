package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService extends CrudServiceImpl<Bill>{
    @Autowired
    BillRepository repo;

    public ResponseEntity<String> update(Bill model, int id) {
        return super.update(this.repo, model, id);
    }
}
