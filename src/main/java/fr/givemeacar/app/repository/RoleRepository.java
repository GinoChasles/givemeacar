package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends
        BaseCrudRepository<Role> {
}