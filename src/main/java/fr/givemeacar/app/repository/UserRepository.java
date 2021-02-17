package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseCrudRepository<User> {

    @Query("SELECT u FROM User u WHERE u.mail = :mail")
    User getUserByMail(@Param("mail") String mail);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);

}