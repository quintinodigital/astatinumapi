package br.com.quintinodigital.astatinumapi.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.quintinodigital.astatinumapi.entity.ArquivoEntity;
import br.com.quintinodigital.astatinumapi.entity.PessoaEntity;
import br.com.quintinodigital.astatinumapi.repository.ArquivoRepository;

@Service
public class ArquivoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArquivoRepository arquivoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	public ArquivoEntity saveOne(MultipartFile multipartFile, Long codigoPessoa) {
		ArquivoEntity arquivoEntity = new ArquivoEntity();
		try {
			arquivoEntity = new ArquivoEntity(multipartFile.getBytes(), multipartFile.getOriginalFilename(), multipartFile.getContentType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		arquivoEntity = this.arquivoRepository.save(arquivoEntity);
		PessoaEntity pessoaEntity = this.pessoaService.findOne(codigoPessoa);
			pessoaEntity.setArquivoEntity(arquivoEntity);
			this.pessoaService.updateOne(pessoaEntity);
		return arquivoEntity;
	}
	
	public ArquivoEntity findOne(Long codigoArquivo) {
		return this.arquivoRepository.findById(codigoArquivo).get();
	}
	
	@SuppressWarnings("unused")
	private String recuperarArquivoString(MultipartFile multipartFile) {
		try {
			return Base64.getEncoder().encodeToString(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
