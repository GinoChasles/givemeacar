package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
 
    @Autowired
    private AdministratorRepository administratorRepository;
 
    public List<Administrator> list() {
        return administratorRepository.findAll();
    }
}