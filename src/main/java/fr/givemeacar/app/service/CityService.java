package fr.givemeacar.app.service;

import fr.givemeacar.app.model.City;
import fr.givemeacar.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des villes
 */
@Service
public class CityService extends CrudServiceImpl<City> {
    @Autowired
    CityRepository repository;

    public CityRepository getRepository() {
        return repository;
    }
}