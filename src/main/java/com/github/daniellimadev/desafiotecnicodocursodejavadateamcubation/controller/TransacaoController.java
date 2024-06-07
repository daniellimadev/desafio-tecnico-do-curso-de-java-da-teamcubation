package com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.controller;

import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.dto.TransacaoDTO;
import com.github.daniellimadev.desafiotecnicodocursodejavadateamcubation.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
