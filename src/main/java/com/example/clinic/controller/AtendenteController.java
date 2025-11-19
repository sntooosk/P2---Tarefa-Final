package com.example.clinic.controller;

import com.example.clinic.model.Atendente;
import com.example.clinic.service.AtendenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/atendentes")
public class AtendenteController {

    private final AtendenteService atendenteService;

    public AtendenteController(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, Object>> cadastrar(@RequestBody Atendente atendente) {
        Atendente salvo = atendenteService.cadastrar(atendente);
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("status", "Cadastro realizado com sucesso");
        resposta.put("atendente", salvo);
        return ResponseEntity.ok(resposta);
    }
}
