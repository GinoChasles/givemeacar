package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends BaseCrudRepository<Car> {
}