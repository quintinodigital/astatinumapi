package br.com.quintinodigital.astatinumapi.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.astatinumapi.entity.ContratoEntity;
import br.com.quintinodigital.astatinumapi.repository.ContratoRepository;
import br.com.quintinodigital.astatinumapi.utility.DateUtility;

@Service
public class ContratoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private ParcelamentoContratualService parcelamentoContratualService;
	
	public List<ContratoEntity> findAll() {
		return this.contratoRepository.findAll();
	}
	
	public ContratoEntity saveOne(ContratoEntity contratoEntity) {
		contratoEntity.setIdentificador(this.gerarIdentificadorReceitaFixa(contratoEntity));
		contratoEntity = this.contratoRepository.save(new ContratoEntity(contratoEntity));
		this.parcelamentoContratualService.gerarParcelamentoContratual(contratoEntity);
		return contratoEntity;
	}
	
	/**
	 * CONTRATO<DATA ASSINATURA CONTRATO><SEQUENCIAL DO DIA>
	 * CONTRATO1012021001RECFIX
	 * @return
	 */
	private String gerarIdentificadorReceitaFixa(ContratoEntity contratoEntity) {
		return "CONTRATO".concat(DateUtility.recuperarDataFormatada(contratoEntity.getDataInicioContrato(), DateUtility.FORMATO_DDMMYYYY)).concat("001").concat("RECFIX");
	}
	
}
