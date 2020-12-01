package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer> {

}
