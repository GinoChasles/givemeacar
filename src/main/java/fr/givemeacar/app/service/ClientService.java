package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService extends CrudServiceImpl<Client> {

    @Autowired
    ClientRepository repository;

    @Override
    public ClientRepository getRepository() {
        return repository;
    }

}
