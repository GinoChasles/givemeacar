package fr.givemeacar.app.repository;

import java.util.Optional;

public interface CrudRepository<T> {
    T findFirstByOrderByIdDesc();

    Optional<T> findById(int id);

    T deleteById(int id);
}
