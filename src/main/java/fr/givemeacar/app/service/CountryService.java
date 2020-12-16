package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends CrudServiceImpl<Country> {
    @Autowired
    CountryRepository repository;

    public CountryRepository getRepository() {
        return repository;
    }
}