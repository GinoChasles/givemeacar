package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Department;
import fr.givemeacar.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Le service des départements
 */
@Service
public class DepartmentService extends CrudServiceImpl<Department> {
    @Autowired
    DepartmentRepository repository;

    public DepartmentRepository getRepository() {
        return repository;
    }
}