package com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.service;

import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.dto.TransacaoDTO;
import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.exceptions.ValidacaoException;
import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.model.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class TransacaoService {

    private static List<Transacao> transacoes =  new ArrayList<>();

    public Transacao salvar(TransacaoDTO transacaoDTO) {

        validaRequest(transacaoDTO);

        Transacao transacao = new Transacao(Double.parseDouble(transacaoDTO.getValor()), OffsetDateTime.parse(transacaoDTO.getDataHora()));
        transacoes.add(transacao);

        log.info("Transação cadastrada com sucesso!");
        return transacao;
    }


    public void validaRequest(TransacaoDTO transacaoDTO) {

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        var dataAgora = formatter.format(offsetDateTime);
        var dataTransacao = formatter.format(offsetDateTime.parse(transacaoDTO.getDataHora()));

        var data = dataTransacao.compareTo(dataAgora);

        if(data > 0) {
            log.error("A data da transacao nao pode estar em um momento futuro.");
            throw new ValidacaoException();
        }

        if(Double.parseDouble(transacaoDTO.getValor()) < 0) {
            log.error("O valor da transacao nao pode ser negativo ");
            throw new ValidacaoException();
        }
    }
}
