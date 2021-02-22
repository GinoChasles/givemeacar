package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des modèles de voiture
 */
@Service
public class ModelService extends CrudServiceImpl<Model> {
    @Autowired
    ModelRepository repository;

    public ModelRepository getRepository() {
        return repository;
    }
}