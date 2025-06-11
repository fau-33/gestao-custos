package com.flaviodevjava.gestao_custos.useCases;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviodevjava.gestao_custos.entity.Despesa;
import com.flaviodevjava.gestao_custos.repository.DespesaRepository;

@Service
public class BuscarDespesaUseCase {

  @Autowired
  private DespesaRepository despesaRepository;

  public List<Despesa> execute(String email, LocalDate data) {

    List<Despesa> despesas;
    if (data != null) {
      despesas = despesaRepository.findByEmailAndData(email, data);
    } else {
      despesas = despesaRepository.findByEmail(email);
    }

    return despesas;
  }

}
