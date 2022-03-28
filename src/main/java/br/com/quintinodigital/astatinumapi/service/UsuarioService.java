package br.com.quintinodigital.astatinumapi.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.astatinumapi.entity.UsuarioEntity;
import br.com.quintinodigital.astatinumapi.repository.UsuarioRepository;
import net.iharder.Base64;

@Service
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioEntity saveOne(UsuarioEntity usuarioEntity) {
		usuarioEntity.setPassword(this.encodePassword(usuarioEntity.getPassword()));
		return this.usuarioRepository.save(new UsuarioEntity(usuarioEntity));
	}
	
	public List<UsuarioEntity> findAll() {
		return this.usuarioRepository.findAll();
	}
	
	private String encodePassword(String password) {
		return Base64.encodeBytes(password.getBytes());
	}
	
	@SuppressWarnings("unused")
	private String decodePasword(String password) {
		byte[] valor;
		try {
			valor = Base64.decode(password);
			return new String(valor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return password;
	}
	
}
