package br.com.quintinodigital.astatinumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinodigital.astatinumapi.entity.CategoriaLancamentoFinanceiroEntity;

@Repository
public interface CategoriaLancamentoFinanceiroRepository extends JpaRepository<CategoriaLancamentoFinanceiroEntity, Long> { }
