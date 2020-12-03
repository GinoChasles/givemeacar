package fr.givemeacar.app.repository;

public interface CrudRepository<T> {
    public T findFirstByOrderByIdDesc();

    public T findById(int id);

    public T deleteById(int id);
}
