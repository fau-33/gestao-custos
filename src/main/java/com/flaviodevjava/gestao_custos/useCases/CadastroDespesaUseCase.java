package com.flaviodevjava.gestao_custos.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviodevjava.gestao_custos.entity.Despesa;
import com.flaviodevjava.gestao_custos.repository.DespesaRepository;

@Service
public class CadastroDespesaUseCase {

  @Autowired
  private DespesaRepository despesaRepository;

  public Despesa execute(Despesa despesa) {

    if (despesa.getCategoria() == null || despesa.getData() == null || despesa.getDescricao() == null
                || despesa.getEmail() == null) {

            throw new IllegalArgumentException("Preencher todos os campos");
        }


    despesa =  despesaRepository.save(despesa);

    return despesa;
    
  }

}
