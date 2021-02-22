package fr.givemeacar.app.service;

import fr.givemeacar.app.model.EnergyType;
import fr.givemeacar.app.repository.EnergyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des types de carburants
 */
@Service
public class EnergyTypeService extends CrudServiceImpl<EnergyType> {
    @Autowired
    EnergyTypeRepository repository;

    public EnergyTypeRepository getRepository() {
        return repository;
    }
}