package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
 
    @Autowired
    private ClientRepository clientRepository;
 
    public List<Client> list() {
        return clientRepository.findAll();
    }
}