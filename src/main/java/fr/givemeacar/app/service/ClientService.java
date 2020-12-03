package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends CrudServiceImpl<Client> {
    @Autowired
    ClientRepository repository;

    public ClientRepository getRepository() {
        return repository;
    }
}