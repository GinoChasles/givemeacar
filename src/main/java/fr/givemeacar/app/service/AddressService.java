package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
 
    @Autowired
    private AddressRepository addressRepository;
 
    public List<Address> list() {
        return addressRepository.findAll();
    }
}