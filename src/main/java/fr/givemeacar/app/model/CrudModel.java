package fr.givemeacar.app.model;

import java.io.Serializable;

/**
 * Interface générique CRUD serializable
 */
public interface CrudModel extends Serializable {
    Integer getId();
    void setId(Integer id);
}
