package fr.givemeacar.app.model;

/**
 * Classe abstraite générique de modèle CRUD
 */
public abstract class CrudModelImpl implements CrudModel{

    private Integer id;

    @Override public Integer getId() {
        return id;
    }

    @Override public void setId(Integer id) {
        this.id = id;
    }
}
