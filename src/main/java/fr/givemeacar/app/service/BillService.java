package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService extends CrudServiceImpl<Bill> {
    @Autowired
    BillRepository repository;

    public BillRepository getRepository() {
        return repository;
    }
}