package br.com.quintinodigital.astatinumapi.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.astatinumapi.entity.PessoaEntity;
import br.com.quintinodigital.astatinumapi.repository.PessoaRepository;

@Service
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaEntity saveOne(PessoaEntity pessoaEntity) {
		return this.pessoaRepository.save(new PessoaEntity(pessoaEntity.getNome()));
	}
	
	public PessoaEntity updateOne(PessoaEntity pessoaEntity) {
		return this.pessoaRepository.save(pessoaEntity);
	}
	
	public void deleteOne(Long codigoPessoa) {
		this.pessoaRepository.deleteById(codigoPessoa);
	}
	
	public List<PessoaEntity> findAll() {
		return this.pessoaRepository.findAll();
	}
	
	public PessoaEntity findOne(Long codigoPessoa) {
		return this.pessoaRepository.findById(codigoPessoa).get();
	}

}
