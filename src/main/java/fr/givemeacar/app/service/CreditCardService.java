package fr.givemeacar.app.service;

import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService extends CrudServiceImpl<CreditCard> {
    @Autowired
    CreditCardRepository repository;

    public CreditCardRepository getRepository() {
        return repository;
    }
}