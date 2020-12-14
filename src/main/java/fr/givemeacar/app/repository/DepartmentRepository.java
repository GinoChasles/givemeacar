package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Department;

public interface DepartmentRepository extends findByNameStartingWithRepository<Department>,
        BaseCrudRepository<Department> {
}