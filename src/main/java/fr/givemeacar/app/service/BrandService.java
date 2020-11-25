package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Brand;
import fr.givemeacar.app.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
 
    @Autowired
    private BrandRepository brandRepository;
 
    public List<Brand> list() {
        return brandRepository.findAll();
    }
}