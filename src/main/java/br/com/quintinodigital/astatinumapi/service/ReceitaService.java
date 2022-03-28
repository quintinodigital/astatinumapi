package br.com.quintinodigital.astatinumapi.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.astatinumapi.entity.CategoriaLancamentoFinanceiroEntity;
import br.com.quintinodigital.astatinumapi.entity.ParcelamentoContratualEntity;
import br.com.quintinodigital.astatinumapi.entity.ReceitaEntity;
import br.com.quintinodigital.astatinumapi.repository.ReceitaImplementacaoRepository;
import br.com.quintinodigital.astatinumapi.repository.ReceitaRepository;
import br.com.quintinodigital.astatinumapi.utility.DateUtility;

@Service
public class ReceitaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ReceitaImplementacaoRepository receitaImplementacaoRepository;
	
	@Autowired
	private ParcelamentoContratualService parcelamentoContratualService;
	
	public List<ReceitaEntity> findAll() {
		return this.receitaRepository.findAll();
	}
	
	public List<ReceitaEntity> recuperarReceitaFixaMensal() {
		return this.receitaImplementacaoRepository.recuperarReceitaFixaMensal();
	}
	
	public ReceitaEntity gerarReceitaFixaMensal() throws Exception {
		ReceitaEntity receitaEntity = new ReceitaEntity();
		ParcelamentoContratualEntity parcelamentoContratualEntity = this.parcelamentoContratualService.recuperarParcelamentoMesAtual();
			try {
				receitaEntity.setParcelamentoContratualEntity(parcelamentoContratualEntity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			receitaEntity.setCategoriaLancamentoFinanceiroEntity(new CategoriaLancamentoFinanceiroEntity(1L));
			receitaEntity.setIdentificador(this.gerarIdentificadorReceita(parcelamentoContratualEntity.getDataPrevista()));
			if(!isReceitaMensalGerada(parcelamentoContratualEntity.getCodigo())) {
				receitaEntity = this.receitaRepository.save(receitaEntity);
			}
		return receitaEntity;
	}
	
	public Boolean isReceitaMensalGerada(Long codigoParcelamentoContratual) throws Exception {
		ParcelamentoContratualEntity parcelamentoContratualEntity = this.parcelamentoContratualService.recuperarParcelamentoMesAtual();
		if(this.receitaImplementacaoRepository.isReceitaMensalGerada(parcelamentoContratualEntity.getCodigo())) {
			return true;
		}
		return false;
	}
	
	/**
	 * <RECFIX><001><01042021>
	 * RECFIX00101042021
	 * @return
	 */
	private String gerarIdentificadorReceita(Date dataPrevista) {
		return "RECFIX".concat("001").concat(DateUtility.recuperarDataFormatada(dataPrevista, DateUtility.FORMATO_DDMMYYYY));
	}

}
