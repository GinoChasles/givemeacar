package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
 
    @Autowired
    private ModelRepository modelRepository;
 
    public List<Model> list() {
        return modelRepository.findAll();
    }
}