package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Service
public class ColorService{
    @Autowired
    ColorRepository repo;

    public Long count(){
        return repo.count();
    }

    public Optional<Color> findById(int id) {
            return repo.findById(id);
    }

    public ResponseEntity<String> create(Color color){
        try{
            repo.save(color);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception exception){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> update(int id, Color color){
        Optional<Color> optionalColor = repo.findById(id);
        Color oldColor;

        if(optionalColor.isPresent()){
            oldColor = optionalColor.get();
            color.setId(oldColor.getId());
            try{
                repo.save(color);
            }catch(DataIntegrityViolationException e){
                String constraint = e.getMessage().split(";")[2].replace(" constraint [","").replace("]","");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\""+constraint+"\"}");
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    public ResponseEntity<String> delete(int id) {
        if (repo.existsById(id)) {
            try {
                repo.deleteById(id);
                return ResponseEntity.ok().build();
            } catch (DataIntegrityViolationException e) {
                String constraint = e.getMessage().split(";")[2].replace(" constraint [", "").replace("]", "");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"" + constraint + "\"}");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
