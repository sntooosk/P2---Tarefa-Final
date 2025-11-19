package com.example.clinic.repository;

import com.example.clinic.model.Agenda;
import com.example.clinic.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByPacienteAndDataAndHora(Paciente paciente, String data, String hora);
}
