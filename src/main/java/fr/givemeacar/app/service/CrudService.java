package fr.givemeacar.app.service;

import java.util.List;
import java.util.Optional;
import fr.givemeacar.app.repository.BaseCrudRepository;
import javax.persistence.EntityManager;

public interface CrudService<T> {

    /**
     * Compte les entités dans la base de données
     *
     * @return le nombre d'entités dans la base de données
     */
     Long count();

    /**
     * Persiste une entité en base de données
     *
     * @param t l'entité à persister
     * @return une réponse 200(ok) ou 409(conflict)
     */
     T create(T t) ;

    /**
     * Met à jour une entité
     *
     * @param t l'objet à mettre à jour
     * @return une réponse 200(ok) ou 409(conflict)
     */
     T update(T t);

    /**
     * supprime une entité en base de donnée
     *
     * @param id l'id de l'entité en base de données
     * @return l'entité supprimée
     */
     Boolean deleteById(Integer id);


    /**
     * Trouve une entité dans la base de dinnées via son id
     *
     * @param id l'id de l'entité à chercher
     * @return l'entité trouvée
     */
     Optional<T> findById(Integer id);

    /**
     * Cherche le dernier modèle en base de données basé sur son id
     * @return le dernier modèle en base de données
     */
     T findLast();


    /**
     * Cherche toutes les entitées dans l'interval donné
     * @param offset l'offset de recherce
     * @param limit  la limite de recherche
     * @param order  l'ordre de recherce (ASC ou DESC)
     * @param sort   le tri effectué (par id, name...)
     * @return une liste d'entités trouvées
     */
     List<T> findAll(int offset, int limit, String order, String sort);

    /**
     * Cherche les entités dont le nom commence par...
     * @param clazz la classe de l'entité
     * @param column la colonne où chercher
     * @param name le nom à chercher
     * @param offset l'offset de recherce
     * @param limit  la limite de recherche
     * @param order  l'ordre de recherce (ASC ou DESC)
     * @param sort   le tri effectué (par id, name...)
     * @return a list of entities starting by the given name
     */
     List<T> findByNameLike(T clazz, String column,String name,String sort,String order,int offset,
                                          int limit);

    /**
     * Le repository rattaché au service
     * @return Le repository rattaché au service
     */
     BaseCrudRepository<?> getRepository();

    /**
     * L'entityManager lié au servie
     * @return L'entityManager lié au servie
     */
     EntityManager getEntityManager();
}