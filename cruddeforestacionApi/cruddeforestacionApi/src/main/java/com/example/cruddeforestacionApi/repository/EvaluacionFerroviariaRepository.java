package com.example.cruddeforestacionApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cruddeforestacionApi.entity.EvaluacionFerroviariaEntity;

@Repository
public interface EvaluacionFerroviariaRepository extends JpaRepository<EvaluacionFerroviariaEntity, Long> {


}
