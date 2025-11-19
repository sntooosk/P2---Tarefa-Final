package com.example.clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "atendentes")
public class Atendente extends Pessoa {

    private String turno;
    private double salario;

    public Atendente() {
    }

    public Atendente(String nome, String cpf, String endereco, String email, String telefone, String turno, double salario) {
        super(nome, cpf, endereco, email, telefone);
        this.turno = turno;
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
