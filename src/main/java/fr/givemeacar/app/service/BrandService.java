package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des constructeurs de voiture
 */
@Service
public  class BrandService extends CrudServiceImpl<Brand> {
    @Autowired
    BrandRepository repository;

    public BrandRepository getRepository() {
        return repository;
    }
}