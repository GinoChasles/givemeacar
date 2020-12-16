package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Manager;
import fr.givemeacar.app.model.UserStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends BaseCrudRepository<Manager> {
    @Query("SELECT c.userStatus FROM Manager c WHERE c.mail = :mail AND c.password = :password")
    public UserStatus findUserStatusByMailAndPassword(@Param("mail") String mail, @Param("password") String password);

}
