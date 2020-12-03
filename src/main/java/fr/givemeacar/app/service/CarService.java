package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService extends CrudServiceImpl<Car>{


    @Autowired
    CarRepository repository;

    @Override
    public CarRepository getRepository() {
        return repository;
    }
}
