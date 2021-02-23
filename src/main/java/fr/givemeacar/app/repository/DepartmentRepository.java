package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends
        BaseCrudRepository<Department> {
}