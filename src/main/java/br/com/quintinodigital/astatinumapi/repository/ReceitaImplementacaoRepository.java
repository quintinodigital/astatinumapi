package br.com.quintinodigital.astatinumapi.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.quintinodigital.astatinumapi.entity.ReceitaEntity;
import br.com.quintinodigital.astatinumapi.utility.DateUtility;

@Repository
public class ReceitaImplementacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	public EntityManager entityManager;

	/**
	 * Responsavel por recuperar das receitas fixas contratuais de um determinado do mes corrente.
	 * @return
	 */
	public List<ReceitaEntity> recuperarReceitaFixaMensal() {
		StringBuilder query = new StringBuilder("SELECT receitaEntity_ ")
				.append("FROM ReceitaEntity receitaEntity_ ")
				.append("JOIN receitaEntity_.parcelamentoContratualEntity parcelamentoContratualEntity_ ")
				.append("JOIN parcelamentoContratualEntity_.contratoEntity contratoEntity_ ")
				.append("JOIN contratoEntity_.pessoaContratanteEntity pessoaContratanteEntity_ ")
				.append("WHERE TO_CHAR(parcelamentoContratualEntity_.dataPrevista, 'MMyyyy') = :ano_mes_corrente_ ");
		TypedQuery<ReceitaEntity> typedQuery = this.entityManager.createQuery(query.toString(), ReceitaEntity.class);
			typedQuery.setParameter("ano_mes_corrente_", DateUtility.recuperarDataFormatada(new Date(), DateUtility.FORMATO_MMYYYY));
		return typedQuery.getResultList();
	}
	
	public Boolean isReceitaMensalGerada(Long codigoParcelamentoContratual) {
		StringBuilder query = new StringBuilder("SELECT receitaEntity_ ")
				.append("FROM ReceitaEntity receitaEntity_ ")
				.append("JOIN receitaEntity_.parcelamentoContratualEntity parcelamentoContratualEntity_ ")
				.append("WHERE parcelamentoContratualEntity_.codigo =: codigoParcelamentoContratualParameter_ ");
		TypedQuery<ReceitaEntity> typedQuery = this.entityManager.createQuery(query.toString(), ReceitaEntity.class);
			typedQuery.setParameter("codigoParcelamentoContratualParameter_", codigoParcelamentoContratual);
		List<ReceitaEntity> receitaEntitieList = typedQuery.getResultList();
		return receitaEntitieList.size() > 0;
	}
	
}
