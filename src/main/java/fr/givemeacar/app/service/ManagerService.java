package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
 
    @Autowired
    private ManagerRepository managerRepository;
 
    public List<Manager> list() {
        return managerRepository.findAll();
    }
}