package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Rent;
import fr.givemeacar.app.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService extends CrudServiceImpl<Rent> {
    @Autowired
    RentRepository repository;

    public RentRepository getRepository() {
        return repository;
    }
}