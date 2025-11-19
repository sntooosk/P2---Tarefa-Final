package com.example.clinic.controller;

import com.example.clinic.model.Medico;
import com.example.clinic.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, Object>> cadastrar(@RequestBody Medico medico) {
        Medico salvo = medicoService.cadastrar(medico);
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("status", "Cadastro realizado com sucesso");
        resposta.put("medico", salvo);
        return ResponseEntity.ok(resposta);
    }
}
