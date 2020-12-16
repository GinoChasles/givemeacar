package fr.givemeacar.app.service;

import fr.givemeacar.app.model.StreetName;
import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.repository.StreetNameRepository;
import fr.givemeacar.app.repository.StreetSuffixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetNameService extends CrudServiceImpl<StreetName> {
    @Autowired
    StreetNameRepository repository;

    public StreetNameRepository getRepository() {
        return repository;
    }
}