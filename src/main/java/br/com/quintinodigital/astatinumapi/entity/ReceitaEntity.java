package br.com.quintinodigital.astatinumapi.entity;

import java.io.Serializable;

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
@Table(name = "TB_RECEITA")
public class ReceitaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@JsonProperty("categoriaLancamentoFinanceiro")
	@OneToOne
	@JoinColumn(name = "ID_CATEGORIA_LANCAMENTO_FINANCEIRO", nullable = false)
	private CategoriaLancamentoFinanceiroEntity categoriaLancamentoFinanceiroEntity;

	@Column(name = "IDENTIFICADOR", nullable = false)
	private String identificador;
	
	@JsonProperty("parcelamentoContratual")
	@OneToOne
	@JoinColumn(name = "ID_PARCELAMENTO_CONTRATUAL")
	private ParcelamentoContratualEntity parcelamentoContratualEntity; // Recuperar Pessoa Origem Recurso a Data de Recebimento e o Valor
	
	public ReceitaEntity() { }

	public ReceitaEntity(Long codigo) {
		this.codigo = codigo;
	}

	public ReceitaEntity(CategoriaLancamentoFinanceiroEntity categoriaLancamentoFinanceiroEntity, String identificador, ParcelamentoContratualEntity parcelamentoContratualEntity) {
		this.categoriaLancamentoFinanceiroEntity = categoriaLancamentoFinanceiroEntity;
		this.identificador = identificador;
		this.parcelamentoContratualEntity = parcelamentoContratualEntity;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CategoriaLancamentoFinanceiroEntity getCategoriaLancamentoFinanceiroEntity() {
		return categoriaLancamentoFinanceiroEntity;
	}

	public void setCategoriaLancamentoFinanceiroEntity( CategoriaLancamentoFinanceiroEntity categoriaLancamentoFinanceiroEntity) {
		this.categoriaLancamentoFinanceiroEntity = categoriaLancamentoFinanceiroEntity;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public ParcelamentoContratualEntity getParcelamentoContratualEntity() {
		return parcelamentoContratualEntity;
	}

	public void setParcelamentoContratualEntity(ParcelamentoContratualEntity parcelamentoContratualEntity) {
		this.parcelamentoContratualEntity = parcelamentoContratualEntity;
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
		ReceitaEntity other = (ReceitaEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
