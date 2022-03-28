package br.com.quintinodigital.astatinumapi;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.quintinodigital.astatinumapi.utility.DateUtility;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
//	@Autowired
//	private PessoaService pessoaService;
	
//	@Autowired
//	private CategoriaContratoRepository categoriaContratoRepository;
	
//	@Autowired
//	private ContratoRepository contratoRepository;
	
//	@Autowired
//	private ParcelamentoContratualRepository parcelamentoContratualRepository;
	
//	@Autowired
//	private CategoriaLancamentoFinanceiroRepository categoriaLancamentoFinanceiroEntity;
	
//	@Autowired
//	private ReceitaRepository receitaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Gerenciar Pessoas
//		PessoaEntity pessoaEntity1 = new PessoaEntity("José Quintinn");
//		PessoaEntity pessoaEntity2 = new PessoaEntity("Mirante Tecnologia da Informação");
//		PessoaEntity pessoaEntity3 = new PessoaEntity("Banco do Brasil S.A");
//		PessoaEntity pessoaEntity4 = new PessoaEntity("Brava Internet Fibra");
//			pessoaEntity1 = this.pessoaService.saveOne(pessoaEntity1);
//			pessoaEntity2 = this.pessoaService.saveOne(pessoaEntity2);
//			pessoaEntity3 =this.pessoaService.saveOne(pessoaEntity3);
//			pessoaEntity4 =this.pessoaService.saveOne(pessoaEntity4);
			
//		for( int index = 1 ; index <= 5 ; index++ ) {
//			PessoaEntity pessoaEntity = new PessoaEntity("Pessoa do Sistema " + index);
//			this.pessoaService.saveOne(pessoaEntity);
//		}
		
		// Gerenciar Categoria Contrato
//		CategoriaContratoEntity categoriaContratoEntity1 = new CategoriaContratoEntity("Contrato de Trabalho Mensalista (CLT)", "Prestação de Serviços de Tecnologia da Informação");
//		CategoriaContratoEntity categoriaContratoEntity2 = new CategoriaContratoEntity("Contrato Bancário", "Contrato de Prestação de Serviços Bancários");
//		CategoriaContratoEntity categoriaContratoEntity3 = new CategoriaContratoEntity("Contrato Serviço de Internet Fixa", "Prestação de Serviço de Internet de Fibra Ótica");
//			this.categoriaContratoRepository.save(categoriaContratoEntity1);
//			this.categoriaContratoRepository.save(categoriaContratoEntity2);
//			this.categoriaContratoRepository.save(categoriaContratoEntity3);
			
			// Gerenciar Contrato
				
			// Gerenciar Parcelamento Contratual
				
			// Gerenciar Categoria do Lancamento Financeiro
//			CategoriaLancamentoFinanceiroEntity categoriaLancamentoFinanceiroEntity1 = new CategoriaLancamentoFinanceiroEntity("Receita Fixa");
//				this.categoriaLancamentoFinanceiroEntity.save(categoriaLancamentoFinanceiroEntity1);
				
			// Gerenciar Receita Fixa
				
			// Gerenciar Despesa Fixa
		
		System.out.println(DateUtility.recuperarDataFormatada(new Date(), DateUtility.FORMATO_DDMMYYYYHHMMSS_SEPARADOR) + " - Servidor Iniciado Com Sucesso!");
	}

}
