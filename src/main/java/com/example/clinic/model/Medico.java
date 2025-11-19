package com.example.clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico extends Pessoa {

    private String crm;
    private String especialidade;

    public Medico() {
    }

    public Medico(String nome, String cpf, String endereco, String email, String telefone, String crm, String especialidade) {
        super(nome, cpf, endereco, email, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
