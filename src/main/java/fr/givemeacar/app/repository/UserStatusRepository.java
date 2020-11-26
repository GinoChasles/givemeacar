package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Integer> {

}
