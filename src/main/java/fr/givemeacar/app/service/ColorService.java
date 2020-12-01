package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ColorService extends CrudServiceImpl<Color> {
    @Autowired
    ColorRepository repo;

    public ResponseEntity<String> create(Color model) {
        return super.create(this.repo,model);
    }

    public ResponseEntity<String> update(Color model,int id) {
        return super.update(this.repo,model,id);
    }
}