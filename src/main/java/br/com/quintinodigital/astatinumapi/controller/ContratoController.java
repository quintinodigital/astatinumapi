package br.com.quintinodigital.astatinumapi.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinodigital.astatinumapi.entity.ContratoEntity;
import br.com.quintinodigital.astatinumapi.service.ContratoService;

@RestController
@RequestMapping("contrato")
public class ContratoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContratoService contratoService;
	
	@PostMapping
	public ContratoEntity saveOne(@RequestBody ContratoEntity contratoEntity) {
		return this.contratoService.saveOne(contratoEntity);
	}
	
	@GetMapping
	public List<ContratoEntity> findAll() {
		return this.contratoService.findAll();
	}

}
