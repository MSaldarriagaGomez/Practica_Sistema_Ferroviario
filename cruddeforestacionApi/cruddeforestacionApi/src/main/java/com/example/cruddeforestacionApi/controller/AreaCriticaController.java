package com.example.cruddeforestacionApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddeforestacionApi.dto.AreaCriticaDTO;
import com.example.cruddeforestacionApi.services.AreaCriticaService;

//el controlador llama al serviio, el servicio al repositorio y wel repositorio es el único que hace consultas a la base de datos

//recibe la información que viene del front, tiene los endpoint

@RestController
@RequestMapping("/api/areas-criticas")
public class AreaCriticaController {

    @Autowired      
    private AreaCriticaService areaCriticaService;

    //recibe peticiones de front y devuleve respuestas, mapeada en un DTO
    //Cada vez que el front haga una peticion de obtener entra aquí
    @GetMapping
    public List<AreaCriticaDTO> getAreasCriticasAll(){
        return areaCriticaService.getAreasCriticasAll();
    }


    //en el path viene una variable tipo long
    @GetMapping("/{id}")
    public ResponseEntity<AreaCriticaDTO> getAreaCriticaById(@PathVariable Long id){
AreaCriticaDTO areaCriticaDTO= areaCriticaService.getAreaCriticaById(id);

return ResponseEntity.ok(areaCriticaDTO);
    
    }

    //cuando uno crea entrega un objeto, se llena con un formulario en el front y se empaqueta en un objeto 
//se convierte json y se envia al api y eso se rcibe, se convierte en dto y el servicio lo convierte en entidad
//para ennviar al repositorio porque solo recibe entidades y se guarda en la base de datos
@PostMapping
public AreaCriticaDTO crearAreaCritica(@RequestBody AreaCriticaDTO areaCriticaDTO){
    return areaCriticaService.crearAreaCritica(areaCriticaDTO);
}
    

   @PutMapping("/{id}")
    public ResponseEntity<AreaCriticaDTO> actualizarById(@PathVariable Long id, @RequestBody AreaCriticaDTO areaCriticaDTO){
        AreaCriticaDTO areaCriticaDTOActualizada= areaCriticaService.actualizarById(id, areaCriticaDTO);
        return ResponseEntity.ok(areaCriticaDTOActualizada);


        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> areaCrtiticaDeleteById(@PathVariable long id){
areaCriticaService.areaCrtiticaDeleteById(id);
return ResponseEntity.noContent().build();

    }

}
