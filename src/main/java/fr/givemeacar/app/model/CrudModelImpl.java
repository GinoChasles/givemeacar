package fr.givemeacar.app.model;

public class CrudModelImpl implements CrudModel{

    private int id;

    @Override public int getId() {
        return id;
    }

    @Override public void setId(int id) {
        this.id = id;
    }
}
