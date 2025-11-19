package com.example.clinic.controller;

import com.example.clinic.model.Paciente;
import com.example.clinic.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, Object>> cadastrar(@RequestBody Paciente paciente) {
        Paciente salvo = pacienteService.cadastrar(paciente);
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("status", "Cadastro realizado com sucesso");
        resposta.put("paciente", salvo);
        return ResponseEntity.ok(resposta);
    }
}
