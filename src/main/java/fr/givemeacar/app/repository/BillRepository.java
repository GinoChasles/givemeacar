package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BillRepository extends JpaRepository<Bill, Integer> {

}
