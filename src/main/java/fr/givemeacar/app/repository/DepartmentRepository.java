package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
