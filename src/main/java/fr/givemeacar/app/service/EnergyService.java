package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Energy;
import fr.givemeacar.app.repository.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyService {
 
    @Autowired
    private EnergyRepository energyRepository;
 
    public List<Energy> list() {
        return energyRepository.findAll();
    }
}