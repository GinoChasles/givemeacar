package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des voitures
 */
@Service
public class CarService extends CrudServiceImpl<Car> {
    @Autowired
    CarRepository repository;

    public CarRepository getRepository() {
        return repository;
    }
}