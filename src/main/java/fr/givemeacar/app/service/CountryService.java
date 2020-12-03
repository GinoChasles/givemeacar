package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.repository.ColorRepository;
import fr.givemeacar.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService extends CrudServiceImpl<Country>{


    @Autowired
    CountryRepository repository;


    @Override
    public CountryRepository getRepository() {
        return repository;
    }
}
