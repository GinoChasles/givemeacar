package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Rent;
import fr.givemeacar.app.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
 
    @Autowired
    private RentRepository rentRepository;
 
    public List<Rent> list() {
        return rentRepository.findAll();
    }
}