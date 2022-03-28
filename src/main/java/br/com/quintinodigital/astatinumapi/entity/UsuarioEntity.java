package br.com.quintinodigital.astatinumapi.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;

	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	public UsuarioEntity() { }

	public UsuarioEntity(String username, String password) {
		this.username = username;
		this.password = password;
		this.isAtivo = true;
	}
	
	public UsuarioEntity(UsuarioEntity usuarioEntity) {
		this.username = usuarioEntity.getUsername();
		this.password = usuarioEntity.getPassword();
		this.isAtivo = true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
