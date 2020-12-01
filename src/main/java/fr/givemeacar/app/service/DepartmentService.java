package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Department;
import fr.givemeacar.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService extends CrudServiceImpl<Department>{
    @Autowired
    DepartmentRepository repo;

    public Long count() {
        return super.count(this.repo);
    }

    public Optional<Department> findById(int id){
        return super.findById(this.repo, id);
    }

    public ResponseEntity<String> create(Department model) {
        return super.create(this.repo, model);
    }

    public ResponseEntity<String> update(Department model, int id) {
        return super.update(this.repo, model, id);
    }

    public ResponseEntity<String> delete(int id){
        return super.delete(this.repo,id);
    }

}
