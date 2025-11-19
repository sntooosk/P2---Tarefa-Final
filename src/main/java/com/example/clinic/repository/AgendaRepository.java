package com.example.clinic.repository;

import com.example.clinic.model.Agenda;
import com.example.clinic.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    Optional<Agenda> findByPacienteAndDataAndHora(Paciente paciente, String data, String hora);
}
