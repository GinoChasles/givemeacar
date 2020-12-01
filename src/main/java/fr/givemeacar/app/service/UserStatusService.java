package fr.givemeacar.app.service;

import fr.givemeacar.app.model.UserStatus;
import fr.givemeacar.app.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserStatusService extends CrudServiceImpl<UserStatus>{
    @Autowired
    UserStatusRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<UserStatus> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(UserStatus model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(UserStatus model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
