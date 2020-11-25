package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
 
    @Autowired
    private CountryRepository countryRepository;
 
    public List<Country> list() {
        return countryRepository.findAll();
    }
}