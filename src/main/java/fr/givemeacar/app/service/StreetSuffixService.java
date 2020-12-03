package fr.givemeacar.app.service;

import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.repository.StreetSuffixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetSuffixService extends CrudServiceImpl<StreetSuffix> {
    @Autowired
    StreetSuffixRepository repository;

    public StreetSuffixRepository getRepository() {
        return repository;
    }
}