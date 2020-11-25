package fr.givemeacar.app.service;

import fr.givemeacar.app.model.City;
import fr.givemeacar.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
 
    @Autowired
    private CityRepository cityRepository;
 
    public List<City> list() {
        return cityRepository.findAll();
    }
}