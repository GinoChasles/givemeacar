package fr.givemeacar.app.service;

import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusService {
 
    @Autowired
    private UserStatusRepository userStatusRepository;
 
    public List<UserStatus> list() {
        return userStatusRepository.findAll();
    }
}