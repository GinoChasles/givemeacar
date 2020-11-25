package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Street;
import fr.givemeacar.app.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {
 
    @Autowired
    private StreetRepository streetRepository;
 
    public List<Street> list() {
        return streetRepository.findAll();
    }
}