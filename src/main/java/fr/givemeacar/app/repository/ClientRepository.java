package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Client;
import fr.givemeacar.app.model.UserStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends BaseCrudRepository<Client> {

    @Query("SELECT c.userStatus FROM Client c WHERE c.mail = :mail AND c.password = :password")
    public UserStatus findUserStatusByMailAndPassword(@Param("mail") String mail, @Param("password") String password);
}