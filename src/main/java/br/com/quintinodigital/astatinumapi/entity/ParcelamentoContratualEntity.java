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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_PARCELAMENTO_CONTRATUAL")
public class ParcelamentoContratualEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@JsonProperty("contrato")
	@OneToOne
	@JoinColumn(name = "ID_CONTRATO", nullable = false)
	private ContratoEntity contratoEntity;
	
	@Column(name = "NUMERO_PARCELA", nullable = false)
	private Integer numeroParcela;
	
	@Column(name = "DATA_PREVISTA", nullable = false)
	private Date dataPrevista;
	
	@Column(name = "DATA_PAGAMENTO")
	private Date dataPagamento;
	
	@Column(name = "VALOR_PREVISTO", nullable = false)
	private Double valorPrevisto;

	public ParcelamentoContratualEntity() { }

	public ParcelamentoContratualEntity(ContratoEntity contratoEntity, Integer numeroParcela, Date dataPrevista, Date dataPagamento, Double valorPrevisto) {
		this.contratoEntity = contratoEntity;
		this.numeroParcela = numeroParcela;
		this.dataPrevista = dataPrevista;
		this.dataPagamento = dataPagamento;
		this.valorPrevisto = valorPrevisto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public ContratoEntity getContratoEntity() {
		return contratoEntity;
	}

	public void setContratoEntity(ContratoEntity contratoEntity) {
		this.contratoEntity = contratoEntity;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorPrevisto() {
		return valorPrevisto;
	}

	public void setValorPrevisto(Double valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
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
		ParcelamentoContratualEntity other = (ParcelamentoContratualEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
