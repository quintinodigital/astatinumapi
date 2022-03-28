package br.com.quintinodigital.astatinumapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_CONTRATO")
public class ContratoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "IDENTIFICADOR", unique = true, nullable = false)
	private String identificador;
	
	@JsonProperty("categoriaContrato")
	@OneToOne
	@JoinColumn(name = "ID_CATEGORIA_CONTRATO", nullable = false)
	private CategoriaContratoEntity categoriaContratoEntity;
	
	@JsonProperty("pessoaContratante")
	@OneToOne
	@JoinColumn(name = "ID_PESSOA_CONTRANTE", nullable = false)
	private PessoaEntity pessoaContratanteEntity;
	
	@JsonProperty("pessoaContrada")
	@OneToOne
	@JoinColumn(name = "ID_PESSOA_CONTRATADA", nullable = false)
	private PessoaEntity pessoaContradaEntity;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO", nullable = false)
	private Date dataInicioContrato;
	
	@Column(name = "DIA_FECHAMENTO", nullable = false)
	private Integer diaFechamento;
	
	@Column(name = "MESES_VIGENCIA", nullable = false)
	private Integer quantidadeMesesVigencia;
	
	@Column(name = "VALOR_CONTRATADO", nullable = false)
	private Double valorContrato;

	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	@Column(name = "OBSERVACAO")
	private String observacao;
	
	public ContratoEntity() { }

	public ContratoEntity(String identificador, CategoriaContratoEntity categoriaContratoEntity, PessoaEntity pessoaContratanteEntity, PessoaEntity pessoaContradaEntity, Date dataInicioContrato, Integer diaFechamento, Integer quantidadeMesesVigencia, Double valorContrato, String observacao) {
		this.identificador = identificador;
		this.categoriaContratoEntity = categoriaContratoEntity;
		this.pessoaContratanteEntity = pessoaContratanteEntity;
		this.pessoaContradaEntity = pessoaContradaEntity;
		this.dataInicioContrato = dataInicioContrato;
		this.quantidadeMesesVigencia = quantidadeMesesVigencia;
		this.valorContrato = valorContrato;
		this.isAtivo = true;
		this.observacao = observacao;
		this.diaFechamento = diaFechamento;
	}
	
	public ContratoEntity(ContratoEntity contratoEntity) {
		this.identificador = contratoEntity.getIdentificador();
		this.categoriaContratoEntity = contratoEntity.getCategoriaContratoEntity();
		this.pessoaContratanteEntity = contratoEntity.getPessoaContratanteEntity();
		this.pessoaContradaEntity = contratoEntity.getPessoaContratanteEntity();
		this.dataInicioContrato = contratoEntity.getDataInicioContrato();
		this.quantidadeMesesVigencia = contratoEntity.getQuantidadeMesesVigencia();
		this.valorContrato = contratoEntity.getValorContrato();
		this.isAtivo = true;
		this.observacao = contratoEntity.getObservacao();
		this.diaFechamento = contratoEntity.getDiaFechamento();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public CategoriaContratoEntity getCategoriaContratoEntity() {
		return categoriaContratoEntity;
	}

	public void setCategoriaContratoEntity(CategoriaContratoEntity categoriaContratoEntity) {
		this.categoriaContratoEntity = categoriaContratoEntity;
	}

	public PessoaEntity getPessoaContratanteEntity() {
		return pessoaContratanteEntity;
	}

	public void setPessoaContratanteEntity(PessoaEntity pessoaContratanteEntity) {
		this.pessoaContratanteEntity = pessoaContratanteEntity;
	}

	public PessoaEntity getPessoaContradaEntity() {
		return pessoaContradaEntity;
	}

	public void setPessoaContradaEntity(PessoaEntity pessoaContradaEntity) {
		this.pessoaContradaEntity = pessoaContradaEntity;
	}

	public Date getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(Date dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public Integer getQuantidadeMesesVigencia() {
		return quantidadeMesesVigencia;
	}

	public void setQuantidadeMesesVigencia(Integer quantidadeMesesVigencia) {
		this.quantidadeMesesVigencia = quantidadeMesesVigencia;
	}

	public Double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(Double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Integer getDiaFechamento() {
		return diaFechamento;
	}

	public void setDiaFechamento(Integer diaFechamento) {
		this.diaFechamento = diaFechamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		ContratoEntity other = (ContratoEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
