package br.com.quintinodigital.astatinumapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.quintinodigital.astatinumapi.entity.ParcelamentoContratualEntity;

@Repository
public interface ParcelamentoContratualRepository extends CrudRepository<ParcelamentoContratualEntity, Long> { 

	@Query("SELECT parcelamentoContratualEntity_ FROM ParcelamentoContratualEntity parcelamentoContratualEntity_ WHERE to_char(data_prevista, 'MMyyyy') = :dataPrevistaParamenter ")
	public ParcelamentoContratualEntity findByDataPrevista(@Param("dataPrevistaParamenter") String dataPrevista);

}
