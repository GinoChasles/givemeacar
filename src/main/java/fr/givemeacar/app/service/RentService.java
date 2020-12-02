package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.Rent;
import fr.givemeacar.app.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentService extends CrudServiceImpl<Rent>{

    @Autowired
    RentRepository repository;

    @Override
    public RentRepository getRepository() {
        return repository;
    }

}
