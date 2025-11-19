package com.example.clinic.service;

import com.example.clinic.model.Agenda;
import com.example.clinic.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public Agenda agendar(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Optional<Agenda> desmarcar(String paciente, String data, String hora) {
        Optional<Agenda> agenda = agendaRepository.findByPacienteAndDataAndHora(paciente, data, hora);
        agenda.ifPresent(agendaRepository::delete);
        return agenda;
    }
}
