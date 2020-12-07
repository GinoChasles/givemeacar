package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Administrator;
import fr.givemeacar.app.model.UserStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdministratorRepository extends BaseCrudRepository<Administrator> {
    @Query("SELECT c.userStatus FROM Administrator c WHERE c.mail = :mail AND c.password = :password")
    public UserStatus findUserStatusByMailAndPassword(@Param("mail") String mail, @Param("password") String password);

}