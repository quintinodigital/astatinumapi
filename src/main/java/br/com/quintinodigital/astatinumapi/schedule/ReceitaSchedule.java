package br.com.quintinodigital.astatinumapi.schedule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.quintinodigital.astatinumapi.entity.ReceitaEntity;
import br.com.quintinodigital.astatinumapi.service.ReceitaService;
import br.com.quintinodigital.astatinumapi.utility.DateUtility;

@Component
public class ReceitaSchedule {
	
	@Autowired
	private ReceitaService receitaService;
	
	// https://crontab.cronhub.io/ (0 0-59 23 28-31 * *)
	// https://stackoverflow.com/a/9939707
	// 20 Segundos = "*/20 * * * * *"
	@Scheduled(cron = "0 0-59 23 28-31 * *") 
	public void gerarReceitaFixaMensal() {
		try {
			ReceitaEntity receitaEntity = this.receitaService.gerarReceitaFixaMensal();
			if(receitaEntity.getCodigo() != null) {
				StringBuilder mensagem = new StringBuilder(DateUtility.recuperarDataFormatada(new Date(), DateUtility.FORMATO_DDMMYYYYHHMMSS_SEPARADOR))
						.append(" - ")
						.append("A Receita Fixa Mensal da Fonte de Pagamento \"")
						.append(receitaEntity.getParcelamentoContratualEntity().getContratoEntity().getPessoaContratanteEntity().getNome())
						.append("\" com Recebimento Previsto em \"")
						.append(DateUtility.recuperarDataFormatada(receitaEntity.getParcelamentoContratualEntity().getDataPrevista(), DateUtility.FORMATO_DDMMYYYY_SEPARADOR))
						.append("\" foi gerada com Sucesso!");
				System.out.println(mensagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
