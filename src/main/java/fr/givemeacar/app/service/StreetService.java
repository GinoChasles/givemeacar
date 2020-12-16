package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetService extends CrudServiceImpl<Street> {
    @Autowired
    StreetRepository repository;

    public StreetRepository getRepository() {
        return repository;
    }
}