package com.example.cruddeforestacionApi.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.cruddeforestacionApi.dto.EvaluacionFerroviariaDTO;
import com.example.cruddeforestacionApi.entity.EvaluacionFerroviariaEntity;

//va a hacer el mapeo de los objets entre dto y entidad
@Mapper
public interface EvaluacionFerroviariaMapper {

    EvaluacionFerroviariaMapper instance= Mappers.getMapper(EvaluacionFerroviariaMapper.class);

    @Mapping(source = "areaCriticaEntity.id", target = "areaCriticaEntityId")
    EvaluacionFerroviariaDTO toDto(EvaluacionFerroviariaEntity evaluacionFerroviariaEntity);

    @Mapping(source = "areaCriticaEntityId", target = "areaCriticaEntity.id")
    EvaluacionFerroviariaEntity toEntity(EvaluacionFerroviariaDTO evaluacionFerroviariaDTO);

    
}
