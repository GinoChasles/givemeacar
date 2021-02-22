package fr.givemeacar.app.service;

import fr.givemeacar.app.model.User;
import fr.givemeacar.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des utilisateurs
 */
@Service
public class UserService extends CrudServiceImpl<User> {
    @Autowired
    UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }
    
}