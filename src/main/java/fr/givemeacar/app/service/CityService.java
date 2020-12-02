package fr.givemeacar.app.service;

import fr.givemeacar.app.model.City;
import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService extends CrudServiceImpl<City>{
    @Override
    public CityRepository getRepository() {
        return repository;
    }

    @Autowired
    CityRepository repository;

}
