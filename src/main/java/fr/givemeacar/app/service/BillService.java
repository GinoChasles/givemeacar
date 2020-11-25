package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Bill;
import fr.givemeacar.app.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
 
    @Autowired
    private BillRepository billRepository;
 
    public List<Bill> list() {
        return billRepository.findAll();
    }
}