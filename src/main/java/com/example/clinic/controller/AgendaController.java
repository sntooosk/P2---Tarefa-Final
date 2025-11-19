package com.example.clinic.controller;

import com.example.clinic.dto.AgendaRequest;
import com.example.clinic.dto.CancelamentoRequest;
import com.example.clinic.model.Agenda;
import com.example.clinic.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping("/agendar-consulta")
    public ResponseEntity<Map<String, Object>> agendarConsulta(@RequestBody AgendaRequest request) {
        Map<String, Object> resposta = new HashMap<>();
        try {
            Agenda salvo = agendaService.agendar(request);
            resposta.put("status", "Agendamento realizado com sucesso");
            resposta.put("agenda", salvo);
            return ResponseEntity.ok(resposta);
        } catch (IllegalArgumentException e) {
            resposta.put("status", e.getMessage());
            resposta.put("agenda", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    @PostMapping("/desmarcar-consulta")
    public ResponseEntity<Map<String, Object>> desmarcarConsulta(@RequestBody CancelamentoRequest request) {
        Map<String, Object> resposta = new HashMap<>();
        agendaService.desmarcar(request.getPacienteId(), request.getData(), request.getHora())
                .ifPresentOrElse(
                        agenda -> {
                            resposta.put("agendamentoCancelado", agenda);
                            resposta.put("status", "Consulta desmarcada com sucesso");
                        },
                        () -> resposta.put("status", "Consulta não encontrada")
                );
        resposta.putIfAbsent("agendamentoCancelado", null);
        return ResponseEntity.ok(resposta);
    }
}
