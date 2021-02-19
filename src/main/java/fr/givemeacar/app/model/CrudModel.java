package fr.givemeacar.app.model;

import java.io.Serializable;

/**
 * Interface générique CRUD serializable
 */
public interface CrudModel extends Serializable {
    public Integer getId();
    public void setId(Integer id);
}
