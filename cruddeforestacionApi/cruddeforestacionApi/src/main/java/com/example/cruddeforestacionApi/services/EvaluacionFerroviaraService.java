package com.example.cruddeforestacionApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddeforestacionApi.dto.EvaluacionFerroviariaDTO;
import com.example.cruddeforestacionApi.entity.EvaluacionFerroviariaEntity;
import com.example.cruddeforestacionApi.excepcion.RecursoNoEncontradoExcepcion;
import com.example.cruddeforestacionApi.repository.AreaCriticaRepository;
import com.example.cruddeforestacionApi.repository.EvaluacionFerroviariaRepository;
import com.example.cruddeforestacionApi.util.EvaluacionFerroviariaMapper;


@Service
public class EvaluacionFerroviaraService {

    @Autowired
    private EvaluacionFerroviariaRepository evaluacionFerroviariaRepository;

    @Autowired
    private AreaCriticaRepository areaCriticaRepository;

    private final EvaluacionFerroviariaMapper mapper= EvaluacionFerroviariaMapper.instance;

    public List<EvaluacionFerroviariaDTO> getEvalucionesFerroviriasAll() {
        List<EvaluacionFerroviariaEntity> evaluacionFerroviariaEntities= evaluacionFerroviariaRepository.findAll();
        return evaluacionFerroviariaEntities.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public EvaluacionFerroviariaDTO getEvaluacionFerroviariaById(Long id) {
   EvaluacionFerroviariaEntity evaluacionFerroviariaEntity= evaluacionFerroviariaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Evaluacion ferroviaria no encontrada"));
    return mapper.toDto(evaluacionFerroviariaEntity);

}

    public EvaluacionFerroviariaDTO newEvaluacionFerroviaria(EvaluacionFerroviariaDTO evaluacionFerroviariaDTO) {
        if (!areaCriticaRepository.existsById(evaluacionFerroviariaDTO.getAreaCriticaEntityId())) {
            throw new RecursoNoEncontradoExcepcion("Area crítica no encontrada");
        }
        
EvaluacionFerroviariaEntity evaluacionFerroviariaEntity= mapper.toEntity(evaluacionFerroviariaDTO);
EvaluacionFerroviariaEntity evaluacionEntityCreada= evaluacionFerroviariaRepository.save(evaluacionFerroviariaEntity);

return mapper.toDto(evaluacionEntityCreada);

    }

    public EvaluacionFerroviariaDTO setEvaluacionFerroviariaID(Long id, EvaluacionFerroviariaDTO evaluacionFerroviariaDTO) {
                EvaluacionFerroviariaEntity evaluacionFerroviariaEntity= evaluacionFerroviariaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Evaluacion ferroviaria no encontrada"));
                evaluacionFerroviariaEntity.setNombreRuta(evaluacionFerroviariaDTO.getNombreRuta());
                evaluacionFerroviariaEntity.setInformeViabilidad(evaluacionFerroviariaDTO.getInformeViabilidad());
                evaluacionFerroviariaEntity.setFechaEvaluacion(evaluacionFerroviariaDTO.getFechaEvaluacion());

                EvaluacionFerroviariaEntity evaluacionFerroviariaEntityActualizada= evaluacionFerroviariaRepository.save(evaluacionFerroviariaEntity);

                return mapper.toDto(evaluacionFerroviariaEntityActualizada);
   
            }

    public void deteleEvaluacionFerroviariaById(Long id) {
      EvaluacionFerroviariaEntity evaluacionFerroviariaEntity= evaluacionFerroviariaRepository.findById(id).orElseThrow(()->new RecursoNoEncontradoExcepcion("Evaluación no encontrada"));
   evaluacionFerroviariaRepository.delete(evaluacionFerroviariaEntity);
   
    }

    
}
