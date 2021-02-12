package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Role;

public interface RoleRepository extends findByNameStartingWithRepository<Role>,
        BaseCrudRepository<Role> {
}