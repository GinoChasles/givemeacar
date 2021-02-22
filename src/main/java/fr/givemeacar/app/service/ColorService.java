package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des couleurs
 */
@Service
public class ColorService extends CrudServiceImpl<Color> {
    @Autowired
    ColorRepository repository;

    public ColorRepository getRepository() {
        return repository;
    }
}