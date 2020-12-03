package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.repository.StreetSuffixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetSuffixService extends CrudServiceImpl<StreetSuffix>{

    @Autowired
    StreetSuffixRepository repository;

    @Override
    public StreetSuffixRepository getRepository() {
        return repository;
    }

}
