package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Color;
import fr.givemeacar.app.model.CreditCard;
import fr.givemeacar.app.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService extends CrudServiceImpl<CreditCard>{


    @Autowired
    CreditCardRepository repository;

    @Override
    public CreditCardRepository getRepository() {
        return repository;
    }
}
