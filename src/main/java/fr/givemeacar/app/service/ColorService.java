package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorService extends CrudServiceImpl<Color>{
    @Autowired
    ColorRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Color> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Color model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Color model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
