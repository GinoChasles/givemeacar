package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Address;
import fr.givemeacar.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends CrudServiceImpl<Address> {
    @Autowired
    AddressRepository repository;

    public AddressRepository getRepository() {
        return repository;
    }

}