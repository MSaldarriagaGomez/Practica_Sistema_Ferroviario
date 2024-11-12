package com.example.cruddeforestacionApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cruddeforestacionApi.entity.AreaCriticaEntity;


//no son clases, son interfaz
@Repository
public interface AreaCriticaRepository extends JpaRepository<AreaCriticaEntity, Long>{


    
}
