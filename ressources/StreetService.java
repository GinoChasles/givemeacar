package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetService extends CrudServiceImpl<Street>{
    @Autowired
    StreetRepository repo;

    public ResponseEntity<String> update(Street model, int id) {
        return super.update(this.repo, model, id);
    }

}
