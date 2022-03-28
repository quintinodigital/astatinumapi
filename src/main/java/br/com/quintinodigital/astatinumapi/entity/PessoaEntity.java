package br.com.quintinodigital.astatinumapi.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@JsonProperty("arquivo")
	@OneToOne
    @JoinColumn(name = "ID_ARQUIVO", nullable = true)
	private ArquivoEntity arquivoEntity;
	
	@Column(name = "NOME", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	public PessoaEntity() { }

	public PessoaEntity(String nome) {
		this.nome = nome;
		this.isAtivo = true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public ArquivoEntity getArquivoEntity() {
		return arquivoEntity;
	}

	public void setArquivoEntity(ArquivoEntity arquivoEntity) {
		this.arquivoEntity = arquivoEntity;
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
		PessoaEntity other = (PessoaEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
