package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.StreetSuffix;
import fr.givemeacar.app.repository.StreetSuffixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetSuffixService extends CrudServiceImpl<StreetSuffix>{
    @Autowired
    StreetSuffixRepository repo;

    public ResponseEntity<String> create(StreetSuffix model) {
        return super.create(this.repo,model);
    }

    public ResponseEntity<String> update(StreetSuffix model,int id) {
        return super.update(this.repo,model,id);
    }
}
