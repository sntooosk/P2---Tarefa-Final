package com.example.clinic.controller;

import com.example.clinic.dto.CaixaOperationRequest;
import com.example.clinic.model.Caixa;
import com.example.clinic.service.CaixaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    private final CaixaService caixaService;

    public CaixaController(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    @PostMapping("/receber-consulta")
    public ResponseEntity<Map<String, Object>> receberConsulta(@RequestBody CaixaOperationRequest request) {
        Caixa caixa = caixaService.registrarOperacao(
                request.getValor(),
                request.getOperacao(),
                request.getData(),
                request.getHora(),
                request.getDescricao()
        );
        return buildResponse("Recebimento de consulta registrado com sucesso", caixa, request);
    }

    @PostMapping("/pagar-medico")
    public ResponseEntity<Map<String, Object>> pagarMedico(@RequestBody CaixaOperationRequest request) {
        Caixa caixa = caixaService.registrarOperacao(
                request.getValor(),
                request.getOperacao(),
                request.getData(),
                request.getHora(),
                "Pagamento para médico: " + request.getMedico()
        );
        Map<String, Object> resposta = buildResponse("Pagamento de médico registrado com sucesso", caixa, request).getBody();
        if (resposta != null) {
            resposta.put("medico", request.getMedico());
        }
        return ResponseEntity.ok(resposta);
    }

    private ResponseEntity<Map<String, Object>> buildResponse(String status, Caixa caixa, CaixaOperationRequest request) {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("status", status);
        resposta.put("operacao", request.getOperacao());
        resposta.put("valor", request.getValor());
        resposta.put("data", caixa.getData());
        resposta.put("hora", caixa.getHora());
        resposta.put("descricao", caixa.getDescricao());
        resposta.put("registro", caixa);
        return ResponseEntity.ok(resposta);
    }
}
