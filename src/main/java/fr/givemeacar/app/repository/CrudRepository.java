package fr.givemeacar.app.repository;

import java.util.Optional;

public interface CrudRepository<T> {
    public T findFirstByOrderByIdDesc();

    public Optional<T> findById(int id);

    public T deleteById(int id);
}
