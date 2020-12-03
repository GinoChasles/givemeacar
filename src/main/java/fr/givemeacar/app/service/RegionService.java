package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Region;
import fr.givemeacar.app.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService extends CrudServiceImpl<Region> {
    @Autowired
    RegionRepository repository;

    public RegionRepository getRepository() {
        return repository;
    }
}