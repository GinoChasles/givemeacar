package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Role;
import fr.givemeacar.app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatusService extends CrudServiceImpl<Role> {
    @Autowired
    RoleRepository repository;

    public RoleRepository getRepository() {
        return repository;
    }
}