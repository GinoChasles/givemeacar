package fr.givemeacar.app.repository;

public interface CrudRepository<CrudModel> {

    public CrudModel findFirstByOrderByIdDesc();
    public CrudModel findById(int id);
    public CrudModel deleteById(int id);
    public Long countById();
}
