package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Car;
import fr.givemeacar.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
 
    @Autowired
    private CarRepository carRepository;
 
    public List<Car> list() {
        return carRepository.findAll();
    }
}