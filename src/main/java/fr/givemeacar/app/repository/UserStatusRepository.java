package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.UserStatus;

public interface UserStatusRepository extends findByNameStartingWithRepository<UserStatus>,
        BaseCrudRepository<UserStatus> {
}