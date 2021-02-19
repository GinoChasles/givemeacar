package fr.givemeacar.app.model;

/**
 * Classe générique de modèle CRUD
 */
public class CrudModelImpl implements CrudModel{

    private Integer id;

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }
}
