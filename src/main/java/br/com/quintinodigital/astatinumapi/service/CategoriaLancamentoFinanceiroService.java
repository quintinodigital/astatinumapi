package br.com.quintinodigital.astatinumapi.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.quintinodigital.astatinumapi.entity.CategoriaLancamentoFinanceiroEntity;
import br.com.quintinodigital.astatinumapi.repository.CategoriaLancamentoFinanceiroRepository;

@Service
public class CategoriaLancamentoFinanceiroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CategoriaLancamentoFinanceiroRepository categoriaLancamentoFinanceiroRepository;
	
	public CategoriaLancamentoFinanceiroEntity findOne(Long codigoCategoriaLancamentoFinanceiro) {
		return this.categoriaLancamentoFinanceiroRepository.findById(codigoCategoriaLancamentoFinanceiro).get();
	}

}
