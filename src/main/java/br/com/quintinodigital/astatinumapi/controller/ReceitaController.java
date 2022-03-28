package br.com.quintinodigital.astatinumapi.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinodigital.astatinumapi.entity.ReceitaEntity;
import br.com.quintinodigital.astatinumapi.service.ReceitaService;

@RestController
@RequestMapping("receita")
public class ReceitaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping
	public List<ReceitaEntity> findAll() {
		return this.receitaService.findAll();
	}
	
	@GetMapping("receita-fixa-mensal")
	public List<ReceitaEntity> recuperarReceitaFixaMensal() {
		return this.receitaService.recuperarReceitaFixaMensal();
	}

}
