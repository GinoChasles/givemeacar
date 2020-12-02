package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.Department;
import fr.givemeacar.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService extends CrudServiceImpl<Department>{


    @Autowired
    DepartmentRepository repository;

    @Override
    public DepartmentRepository getRepository() {
        return repository;
    }
}
