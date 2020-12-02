package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService extends CrudServiceImpl<Manager>{

    @Autowired
    ManagerRepository repository;

    @Override
    public ManagerRepository getRepository() {
        return repository;
    }


}
