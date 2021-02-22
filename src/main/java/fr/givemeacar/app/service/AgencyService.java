package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des agences
 */
@Service
public class AgencyService extends CrudServiceImpl<Agency> {
    @Autowired
    AgencyRepository repository;

    public AgencyRepository getRepository() {
        return repository;
    }
}