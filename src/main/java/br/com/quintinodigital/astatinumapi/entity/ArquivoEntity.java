package br.com.quintinodigital.astatinumapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ARQUIVO")
public class ArquivoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Column(name = "NOME_ARQUIVO", nullable = false)
	private String nomeArquivo;
	
	@Column(name = "EXTENCAO", nullable = false)
	private String extencao;
	
	@Column(name = "DATA_ATUALIZACAO", nullable = true)
	private Date dataAtualizacao;
	
	@Lob
	@Column(name = "IMAGEM")
	private byte[] imagem;
	
	public ArquivoEntity() { }

	public ArquivoEntity(byte[] imagem, String nomeArquivo, String extencao) {
		this.imagem = imagem;
		this.nomeArquivo = nomeArquivo;
		this.extencao = extencao;
		this.dataAtualizacao = new Date();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getExtencao() {
		return extencao;
	}

	public void setExtencao(String extencao) {
		this.extencao = extencao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

}
