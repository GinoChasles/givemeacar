package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
 
    @Autowired
    private ColorRepository colorRepository;
 
    public List<Color> list() {
        return colorRepository.findAll();
    }
}