package br.com.quintinodigital.astatinumapi.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.quintinodigital.astatinumapi.entity.ArquivoEntity;
import br.com.quintinodigital.astatinumapi.service.ArquivoService;

@RestController
@RequestMapping("arquivo")
public class ArquivoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ArquivoService arquivoService;
	
	@PostMapping
	public ArquivoEntity saveOne(@RequestParam("arquivo") MultipartFile multipartFile, @RequestParam("codigoPessoa") Long codigoPessoa) {
		return this.arquivoService.saveOne(multipartFile, codigoPessoa);
	}
	
	@GetMapping("{codigoArquivo}")
	public ResponseEntity<Resource> findOne(@PathVariable Long codigoArquivo) {
		ArquivoEntity arquivoEntity = this.arquivoService.findOne(codigoArquivo);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(arquivoEntity.getExtencao()))
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivoEntity.getNomeArquivo() + "\"").body(new ByteArrayResource(arquivoEntity.getImagem()));
	}
	
	@GetMapping("/recuperar/{codigoArquivo}")
	public ResponseEntity<String> findURLFile(@PathVariable Long codigoArquivo) {
		ArquivoEntity arquivoEntity = this.arquivoService.findOne(codigoArquivo);
		String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/arquivo/" + arquivoEntity.getCodigo()).toUriString();
		return ResponseEntity.ok().body(url);
	}

}
