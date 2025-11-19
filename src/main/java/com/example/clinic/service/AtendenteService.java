package com.example.clinic.service;

import com.example.clinic.model.Atendente;
import com.example.clinic.repository.AtendenteRepository;
import org.springframework.stereotype.Service;

@Service
public class AtendenteService {

    private final AtendenteRepository atendenteRepository;

    public AtendenteService(AtendenteRepository atendenteRepository) {
        this.atendenteRepository = atendenteRepository;
    }

    public Atendente cadastrar(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }
}
