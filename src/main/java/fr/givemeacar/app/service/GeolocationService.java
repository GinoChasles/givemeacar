package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Geolocation;
import fr.givemeacar.app.repository.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeolocationService {
 
    @Autowired
    private GeolocationRepository geolocationRepository;
 
    public List<Geolocation> list() {
        return geolocationRepository.findAll();
    }
}