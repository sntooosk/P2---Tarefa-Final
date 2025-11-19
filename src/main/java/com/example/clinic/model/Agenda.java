package com.example.clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Entidade que representa um agendamento de consulta no banco de dados.
@Entity
@Table(name = "agendas")
public class Agenda {

    // Identificador único gerado automaticamente pela JPA.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Paciente associado à consulta.
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // Médico responsável pela consulta.
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    // Data da consulta no formato dd/MM/yyyy.
    private String data;

    // Horário da consulta.
    private String hora;

    // Valor cobrado pela consulta.
    private double valorConsulta;

    // Construtor padrão exigido pelo JPA.
    public Agenda() {
    }

    // Construtor usado para criar novas instâncias de agendamento.
    public Agenda(Paciente paciente, Medico medico, String data, String hora, double valorConsulta) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
        this.valorConsulta = valorConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}
