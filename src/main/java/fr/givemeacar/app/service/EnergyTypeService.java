package fr.givemeacar.app.service;

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

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<EnergyType> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(EnergyType model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(EnergyType model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
