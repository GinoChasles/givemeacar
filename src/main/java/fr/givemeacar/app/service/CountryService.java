package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.Country;
import fr.givemeacar.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService extends CrudServiceImpl<Country>{
    @Autowired
    CountryRepository repo;

    public ResponseEntity<String> create(Country model) {
        return super.create(this.repo,model);
    }

    public ResponseEntity<String> update(Country model,int id) {
        return super.update(this.repo,model,id);
    }
}
