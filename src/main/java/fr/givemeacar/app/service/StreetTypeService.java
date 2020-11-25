package fr.givemeacar.app.service;

import fr.givemeacar.app.model.StreetType;
import fr.givemeacar.app.repository.StreetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetTypeService {
 
    @Autowired
    private StreetTypeRepository streetTypeRepository;
 
    public List<StreetType> list() {
        return streetTypeRepository.findAll();
    }
}