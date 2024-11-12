package com.example.cruddeforestacionApi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddeforestacionApi.dto.AreaCriticaDTO;
import com.example.cruddeforestacionApi.entity.AreaCriticaEntity;
import com.example.cruddeforestacionApi.excepcion.RecursoNoEncontradoExcepcion;
import com.example.cruddeforestacionApi.repository.AreaCriticaRepository;


 //patron de diseno dto para aislar la capa de datos de la capa cliente
    //el servicio se comunica con el repositorio a través de las entidades y el controlador 

@Service
public class AreaCriticaService {

    @Autowired
    private AreaCriticaRepository areaCriticaRepository;

    //el repositorio trabaja con una lista de entidades, él entrega una lista de entidades
    //en este caso de AreacriticaEntity... osea que el repositorio va y busca y entrega la lista
    //pero yo no puedo entregar una lista de entidades. tengo que hacer un mapeo y convertirla en dto, por aislamiento de capas
    public List<AreaCriticaDTO> getAreasCriticasAll() {
        List<AreaCriticaEntity> areaCriticaEntities =areaCriticaRepository.findAll();

        //crear flujo de datos para poderlos trabajar
        //el stream me lo convierte en un flujo de datos, mapeo cada uno de los datos, de las entidades convirtiendolas en dto
        //el collectors.tolist le esta diciendo que me convierta todo eso en una lista
        // de lista a flujo y de flujo a lista
        return areaCriticaEntities.stream().map(this:: convertirDTO).collect(Collectors.toList());
    }

    public AreaCriticaDTO getAreaCriticaById(Long id) {

        //en el casso de que lo encuentre lo entrega y si no, entrega el error
        AreaCriticaEntity areaCriticaEntity= areaCriticaRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Area critica no encontrada"));


        return convertirDTO(areaCriticaEntity);
    };

    //me recibe una entidad y me devuelve un dto
    private AreaCriticaDTO convertirDTO(AreaCriticaEntity areaCriticaEntity){


        //creo un objeto dto y seteo
        AreaCriticaDTO areaCriticaDTO= new AreaCriticaDTO();

        areaCriticaDTO.setId(areaCriticaEntity.getId());
        areaCriticaDTO.setNombre(areaCriticaEntity.getNombre());
        areaCriticaDTO.setDescripcion(areaCriticaEntity.getDescripcion());
        areaCriticaDTO.setLatitud(areaCriticaEntity.getLatitud());
        areaCriticaDTO.setLongitud(areaCriticaEntity.getLongitud());
        areaCriticaDTO.setIndiceDeforestacion(areaCriticaEntity.getIndiceDeforestacion());

        return areaCriticaDTO;

    };

   
    private AreaCriticaEntity convertirEntity(AreaCriticaDTO areaCriticaDTO){


        //creo un objeto dto y seteo
       AreaCriticaEntity areaCriticaEntity= new AreaCriticaEntity();

       areaCriticaEntity.setNombre(areaCriticaDTO.getNombre());
       areaCriticaEntity.setDescripcion(areaCriticaDTO.getDescripcion());
       areaCriticaEntity.setLatitud(areaCriticaDTO.getLatitud());
       areaCriticaEntity.setLongitud(areaCriticaDTO.getLongitud());
       areaCriticaEntity.setIndiceDeforestacion(areaCriticaDTO.getIndiceDeforestacion());

        return areaCriticaEntity;

    }

   
    //el repositorio solo recibe entidades, entonces debemos tener la funcion al contrario, para cuando ingresen datos


    public AreaCriticaDTO crearAreaCritica(AreaCriticaDTO areaCriticaDTO){
        AreaCriticaEntity areaCriticaEntity= convertirEntity(areaCriticaDTO);
       AreaCriticaEntity areaCriticaEntityCreada= areaCriticaRepository.save(areaCriticaEntity);
                return convertirDTO(areaCriticaEntityCreada);

    }

    public AreaCriticaDTO actualizarById(Long id, AreaCriticaDTO areaCriticaDTO) {
AreaCriticaEntity areaCriticaEntity=areaCriticaRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Area critica no encontrada"));
areaCriticaEntity.setNombre(areaCriticaDTO.getNombre());
areaCriticaEntity.setDescripcion(areaCriticaDTO.getDescripcion());
areaCriticaEntity.setLatitud(areaCriticaDTO.getLatitud());
areaCriticaEntity.setLongitud(areaCriticaDTO.getLongitud());
areaCriticaEntity.setIndiceDeforestacion(areaCriticaDTO.getIndiceDeforestacion());

AreaCriticaEntity areaCriticaEntityActualizada= areaCriticaRepository.save(areaCriticaEntity);
return convertirDTO(areaCriticaEntityActualizada);
    }

    public void areaCrtiticaDeleteById(long id) {
        AreaCriticaEntity areaCriticaEntity=areaCriticaRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Area critica no encontrada"));
        areaCriticaRepository.delete(areaCriticaEntity);
    }

 
    
}