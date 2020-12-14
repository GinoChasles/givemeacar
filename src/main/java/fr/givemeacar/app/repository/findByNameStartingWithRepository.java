package fr.givemeacar.app.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface findByNameStartingWithRepository<T> {
    public List<T> findByNameStartingWith(String name);
}
