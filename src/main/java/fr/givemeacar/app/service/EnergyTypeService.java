package fr.givemeacar.app.service;

import fr.givemeacar.app.model.energyType;
import fr.givemeacar.app.repository.energyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class energyTypeService {
 
    @Autowired
    private energyTypeRepository energyTypeRepository;
 
    public List<energyType> list() {
        return energyTypeRepository.findAll();
    }
}