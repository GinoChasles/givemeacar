package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BrandService extends CrudServiceImpl<Brand>{


    @Autowired
    BrandRepository repository;

    @Override
    public BrandRepository getRepository() {
        return repository;
    }
}
