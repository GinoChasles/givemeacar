package fr.givemeacar.app.controller;

import fr.givemeacar.app.model.CrudModel;
import fr.givemeacar.app.service.CrudService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

/**
 * Interface d'un contrôleur CRUD générique
 * @param <T> le model rattaché au contrôleur
 */
public interface CrudController<T> {

    /**
     * Compte les entités dans la table
     * @return le nombre d'entités dans la table
     */
    public ResponseEntity count();

    /**
     * Cherche l'entité dans la table via son id
     * @param id l'id de l'entité à trouver
     * @return l'entité trouvée
     */
    public ResponseEntity findById(@PathVariable int id);

    /**
     * Cherche plusieurs entités via leur id (requête react-admin)
     * @param id l'id des entités à chercher
     * @return les entités trouvées
     */
    public ResponseEntity<?> listById(int id);

    /**
     * @param _order l'ordre ASC ou DESC
     * @param _sort la façon dont les données sont ordonées
     * @param _start le début de la recherche (OFFSET)
     * @param _end la fin de la recherche (LIMIT)
     * @param id l'identifiant de l'entité à chercher
     * @param q la requête de recherche
     * @return un response entity contenant toutes les données trouvées
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public ResponseEntity findAll(@RequestParam(required = false) String _order,
            @RequestParam(required = false) String _sort, @RequestParam(required = false) Integer _start,
            @RequestParam(required = false) Integer _end, @RequestParam(required = false) Integer id,
                                  @RequestParam(required = false) String q)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    /**
     *
     * Crée une entité dans la table
     * @param model l'entité à persister
     * @return l'entité persistée
     */
    public ResponseEntity create(@Valid @RequestBody T model) throws Exception;

    /**
     * met à jour une entité dans la table
     * @param model l'entité à mettre à  jour
     * @return l'entité mise à jour
     */
    public ResponseEntity update(@RequestBody T model);


    /**
     * Supprime l'entité dans la table via son id
     * @param id l'id de l'entité à supprimer
     * @return l'entité supprimée
     */
    public ResponseEntity deleteById(@PathVariable int id);

    /**
     * Retourne le service rattaché au contrôleur
     * @return le service rattaché au contrôleur
     */
    public CrudService<T> getService();
}