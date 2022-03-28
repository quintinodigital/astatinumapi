package br.com.quintinodigital.astatinumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinodigital.astatinumapi.entity.ContratoEntity;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoEntity, Long> { }
