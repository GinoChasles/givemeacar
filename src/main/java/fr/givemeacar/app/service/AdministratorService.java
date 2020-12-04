package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService extends CrudServiceImpl<Administrator> {
    @Autowired
    AdministratorRepository repository;

    public AdministratorRepository getRepository() {
        return repository;
    }
}