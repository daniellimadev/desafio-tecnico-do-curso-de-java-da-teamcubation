package com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.controller;

import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.dto.EstatisticasDTO;
import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.dto.TransacaoDTO;
import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transacao", produces = {"application/json"})
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        transacaoService.salvar(transacaoDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticasDTO> findAll() {

        return ResponseEntity.ok(transacaoService.estatisticas());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar() {
        transacaoService.deletar();
        return ResponseEntity.status(200).build();
    }
}
