package fr.givemeacar.app.repository;

import fr.givemeacar.app.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

}
