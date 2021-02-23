package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Agency;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    public T findFirstByOrderByIdDesc();

    public Optional<T> findById(int id);

    public T deleteById(int id);
}
