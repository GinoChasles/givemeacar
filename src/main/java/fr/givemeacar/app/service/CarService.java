package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService extends CrudServiceImpl<Car> {
    @Autowired
    CarRepository repository;

    public CarRepository getRepository() {
        return repository;
    }
}