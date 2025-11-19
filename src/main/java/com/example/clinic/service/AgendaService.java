package com.example.clinic.service;

import com.example.clinic.dto.AgendaRequest;
import com.example.clinic.model.Agenda;
import com.example.clinic.model.Medico;
import com.example.clinic.model.Paciente;
import com.example.clinic.repository.AgendaRepository;
import com.example.clinic.repository.MedicoRepository;
import com.example.clinic.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public AgendaService(AgendaRepository agendaRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.agendaRepository = agendaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public Agenda agendar(AgendaRequest request) {
        Paciente paciente = pacienteRepository.findById(request.getPacienteId())
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));
        Medico medico = medicoRepository.findById(request.getMedicoId())
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado"));

        Agenda agenda = new Agenda(
                paciente,
                medico,
                request.getData(),
                request.getHora(),
                request.getValorConsulta()
        );
        return agendaRepository.save(agenda);
    }

    public Optional<Agenda> desmarcar(Long pacienteId, String data, String hora) {
        return pacienteRepository.findById(pacienteId)
                .flatMap(paciente -> {
                    Optional<Agenda> agenda = agendaRepository.findByPacienteAndDataAndHora(paciente, data, hora);
                    agenda.ifPresent(agendaRepository::delete);
                    return agenda;
                });
    }
}
