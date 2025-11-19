package com.example.clinic.repository;

import com.example.clinic.model.Agenda;
import com.example.clinic.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repositório responsável pelas operações de persistência de agendamentos.
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    // Recupera uma agenda específica para o paciente, data e hora fornecidos.
    Optional<Agenda> findByPacienteAndDataAndHora(Paciente paciente, String data, String hora);
}
