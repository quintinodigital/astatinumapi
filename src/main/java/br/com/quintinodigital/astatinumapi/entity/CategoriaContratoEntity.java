package br.com.quintinodigital.astatinumapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CATEGORIA_CONTRATO")
public class CategoriaContratoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "DESCRICAO_CONTRATO", unique = true, nullable = false)
	private String descricaoContrato;
	
	@Column(name = "DESCRICAO_SERVICO", unique = true, nullable = false)
	private String descricaoServico;

	public CategoriaContratoEntity() { }

	public CategoriaContratoEntity(String descricaoContrato, String descricaoServico) {
		this.descricaoContrato = descricaoContrato;
		this.descricaoServico = descricaoServico;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoContrato() {
		return descricaoContrato;
	}

	public void setDescricaoContrato(String descricaoContrato) {
		this.descricaoContrato = descricaoContrato;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaContratoEntity other = (CategoriaContratoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
