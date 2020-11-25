package fr.givemeacar.app.service;

import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.repository.StreetSuffixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetSuffixService {
 
    @Autowired
    private StreetSuffixRepository streetSuffixRepository;
 
    public List<StreetSuffix> list() {
        return streetSuffixRepository.findAll();
    }
}