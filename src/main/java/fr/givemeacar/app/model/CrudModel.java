package fr.givemeacar.app.model;

import java.io.Serializable;

public interface CrudModel extends Serializable {
    public int getId();
    public void setId(int id);
}
