package br.com.quintinodigital.astatinumapi.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinodigital.astatinumapi.entity.PessoaEntity;
import br.com.quintinodigital.astatinumapi.service.PessoaService;

@RestController
@RequestMapping("pessoa")
@CrossOrigin("*")
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<PessoaEntity> findAll() {
		return this.pessoaService.findAll();
	}
	
	@PostMapping
	public PessoaEntity saveOne(@RequestBody PessoaEntity pessoaEntity) {
		return this.pessoaService.saveOne(pessoaEntity);
	}
	
	@PutMapping
	public PessoaEntity updateOne(@RequestBody PessoaEntity pessoaEntity) {
		return this.pessoaService.updateOne(pessoaEntity);
	}
	
	@DeleteMapping("{codigoPessoa}")
	public void deleteOne(@PathVariable Long codigoPessoa) {
		this.pessoaService.deleteOne(codigoPessoa);
	}

}
