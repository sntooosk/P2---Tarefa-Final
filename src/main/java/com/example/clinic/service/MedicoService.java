package com.example.clinic.service;

import com.example.clinic.model.Medico;
import com.example.clinic.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrar(Medico medico) {
        return medicoRepository.save(medico);
    }
}
