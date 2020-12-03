package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyService extends CrudServiceImpl<Agency> {

    @Autowired
    AgencyRepository repository;

    @Override
    public AgencyRepository getRepository() {
        return repository;
    }

}
