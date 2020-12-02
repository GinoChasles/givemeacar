package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.Region;
import fr.givemeacar.app.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegionService extends CrudServiceImpl<Region>{


    @Autowired
    RegionRepository repository;

    @Override
    public RegionRepository getRepository() {
        return repository;
    }

}
