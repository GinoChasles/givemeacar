package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends BaseCrudRepository<Bill> {
}