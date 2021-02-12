package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Role;

public interface UserStatusRepository extends findByNameStartingWithRepository<Role>,
        BaseCrudRepository<Role> {
}