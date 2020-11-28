package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserStatusRepository extends JpaRepository<UserStatus, Integer> {

}
