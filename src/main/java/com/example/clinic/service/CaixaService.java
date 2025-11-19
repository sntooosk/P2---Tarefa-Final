package com.example.clinic.service;

import com.example.clinic.model.Caixa;
import com.example.clinic.repository.CaixaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class CaixaService {

    private final CaixaRepository caixaRepository;

    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    public Caixa registrarOperacao(double valor, String operacao, String data, String hora, String descricao) {
        String dataOperacao = data != null && !data.isBlank()
                ? data
                : LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        String horaOperacao = hora != null && !hora.isBlank()
                ? hora
                : LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        Caixa caixa = new Caixa(valor, operacao, dataOperacao, horaOperacao, descricao);
        return caixaRepository.save(caixa);
    }
}
