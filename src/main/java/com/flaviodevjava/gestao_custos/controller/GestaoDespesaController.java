package com.flaviodevjava.gestao_custos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flaviodevjava.gestao_custos.custom_messages.ErrorMessage;
import com.flaviodevjava.gestao_custos.entity.Despesa;
import com.flaviodevjava.gestao_custos.useCases.BuscarDespesaUseCase;
import com.flaviodevjava.gestao_custos.useCases.CadastroDespesaUseCase;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

  @Autowired
  BuscarDespesaUseCase buscarDespesaUseCase;

  @Autowired
  CadastroDespesaUseCase cadastroDespesaUseCase; 
  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody Despesa despesa) {

    try {
      var result = cadastroDespesaUseCase.execute(despesa);

      return ResponseEntity.ok(result);
      
    } catch (IllegalArgumentException e) {
      var errorMessage =  new ErrorMessage(e.getMessage(), "INVALID_PARAMS");
      return ResponseEntity.status(400).body(errorMessage);
    }
  }

  @GetMapping("/{email}")
  public List<Despesa> findByEmailAndData(@PathVariable String email, @RequestParam(required = false) LocalDate data) {

    return buscarDespesaUseCase.execute(email, data);
  }

}
