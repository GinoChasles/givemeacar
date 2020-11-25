package fr.givemeacar.app.service;

import fr.givemeacar.app.model.Agency;
import fr.givemeacar.app.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public List<Agency> list() {
        return agencyRepository.findAll();
    }
}