package fr.givemeacar.app.service;

import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
 
    @Autowired
    private CreditCardRepository creditCardRepository;
 
    public List<CreditCard> list() {
        return creditCardRepository.findAll();
    }
}