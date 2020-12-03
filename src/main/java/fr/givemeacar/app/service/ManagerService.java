package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends CrudServiceImpl<Manager> {
    @Autowired
    ManagerRepository repository;

    public ManagerRepository getRepository() {
        return repository;
    }
}