package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.EnergyType;
import fr.givemeacar.app.repository.EnergyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnergyTypeService extends CrudServiceImpl<EnergyType>{
    @Autowired
    EnergyTypeRepository repo;

    public ResponseEntity<String> create(EnergyType model) {
        return super.create(this.repo,model);
    }

    public ResponseEntity<String> update(EnergyType model,int id) {
        return super.update(this.repo,model,id);
    }
}
