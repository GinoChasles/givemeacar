package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.userStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userStatusRepository extends JpaRepository<userStatus, Integer> {

}
