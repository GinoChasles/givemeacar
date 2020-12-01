package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService extends CrudServiceImpl<Client>{
    @Autowired
    ClientRepository repo;

    public ResponseEntity<String> create(Client model) {
        return super.create(this.repo,model);
    }

    public ResponseEntity<String> update(Client model,int id) {
        return super.update(this.repo,model,id);
    }}
