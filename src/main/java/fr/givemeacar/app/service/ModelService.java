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

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Model> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Model model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Model model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
