package com.flaviodevjava.gestao_custos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flaviodevjava.gestao_custos.entity.Despesa;
import com.flaviodevjava.gestao_custos.useCases.CadastroDespesaUseCase;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

  @Autowired
  CadastroDespesaUseCase cadastroDespesaUseCase; 
  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody Despesa despesa) {

    try {
      var result = cadastroDespesaUseCase.execute(despesa);

      return ResponseEntity.ok(result);
      
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

}
