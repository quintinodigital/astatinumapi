package br.com.quintinodigital.astatinumapi.service;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.astatinumapi.entity.ContratoEntity;
import br.com.quintinodigital.astatinumapi.entity.ParcelamentoContratualEntity;
import br.com.quintinodigital.astatinumapi.repository.ParcelamentoContratualRepository;
import br.com.quintinodigital.astatinumapi.utility.DateUtility;

@Service
public class ParcelamentoContratualService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ParcelamentoContratualRepository parcelamentoContratualRepository;
	
	public void gerarParcelamentoContratual(ContratoEntity contratoEntity) {
		for( int index = 0 ; index < contratoEntity.getQuantidadeMesesVigencia() ; index++ ) {
			ParcelamentoContratualEntity parcelamentoContratualEntity = new ParcelamentoContratualEntity();
				parcelamentoContratualEntity.setContratoEntity(contratoEntity);
				parcelamentoContratualEntity.setNumeroParcela(index + 1);
				parcelamentoContratualEntity.setValorPrevisto(contratoEntity.getValorContrato());
				parcelamentoContratualEntity.setDataPagamento(null);
				parcelamentoContratualEntity.setDataPrevista(DateUtility.gerarDataPorDiaReferencia(contratoEntity.getDiaFechamento(), (DateUtility.recuperarMesDataReferencia(contratoEntity.getDataInicioContrato()) + index + 1), contratoEntity.getDataInicioContrato()));
				this.parcelamentoContratualRepository.save(parcelamentoContratualEntity);
		}
	}
	
	public ParcelamentoContratualEntity recuperarParcelamentoMesAtual() throws Exception {
		ParcelamentoContratualEntity parcelamentoContratualEntity = this.parcelamentoContratualRepository.findByDataPrevista(DateUtility.recuperarDataFormatada(new Date(), DateUtility.FORMATO_MMYYYY));
		if(parcelamentoContratualEntity == null) {
			throw new Exception("Não foi possível indentificar o Parcelamento!");
		} else {
			return parcelamentoContratualEntity;
		}
	}

}
