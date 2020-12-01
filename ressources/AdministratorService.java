package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorService extends CrudServiceImpl<Administrator>{
    @Autowired
    AdministratorRepository repo;

    public ResponseEntity<String> update(Administrator model, int id) {
        return super.update(this.repo, model, id);
    }

}
