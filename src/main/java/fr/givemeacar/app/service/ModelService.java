package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Model;
import fr.givemeacar.app.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelService extends CrudServiceImpl<Model>{
    @Autowired
    ModelRepository repo;

    public ResponseEntity<String> update(Model model, int id) {
        return super.update(this.repo, model, id);
    }

}
