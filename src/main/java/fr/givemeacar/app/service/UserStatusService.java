package fr.givemeacar.app.service;

import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatusService extends CrudServiceImpl<UserStatus> {
    @Autowired
    UserStatusRepository repository;

    public UserStatusRepository getRepository() {
        return repository;
    }
}