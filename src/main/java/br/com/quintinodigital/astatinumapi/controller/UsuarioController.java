package br.com.quintinodigital.astatinumapi.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinodigital.astatinumapi.entity.UsuarioEntity;
import br.com.quintinodigital.astatinumapi.service.UsuarioService;

@RestController
@RequestMapping("usuario")
@CrossOrigin("*")
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public UsuarioEntity saveOne(@RequestBody UsuarioEntity usuarioEntity) {
		return this.usuarioService.saveOne(usuarioEntity);
	}
	
	@GetMapping
	public List<UsuarioEntity> findAll() {
		return this.usuarioService.findAll();
	}

}
