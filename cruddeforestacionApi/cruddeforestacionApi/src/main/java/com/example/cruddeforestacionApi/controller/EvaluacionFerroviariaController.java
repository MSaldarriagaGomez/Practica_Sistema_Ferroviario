package com.example.cruddeforestacionApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddeforestacionApi.dto.EvaluacionFerroviariaDTO;
import com.example.cruddeforestacionApi.services.EvaluacionFerroviaraService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/evaluciones-ferroviarias")
public class EvaluacionFerroviariaController {
    

    @Autowired
    private EvaluacionFerroviaraService evaluacionFerroviaraService;

    @GetMapping
    public List<EvaluacionFerroviariaDTO> getEvalucionesFerroviriasAll() {
        return evaluacionFerroviaraService.getEvalucionesFerroviriasAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionFerroviariaDTO> getEvaluacionFerroviariaById(@PathVariable Long id) {
        EvaluacionFerroviariaDTO evaluacionFerroviariaDTO= evaluacionFerroviaraService.getEvaluacionFerroviariaById(id);
        return ResponseEntity.ok(evaluacionFerroviariaDTO);
    }

    @PostMapping()
    public EvaluacionFerroviariaDTO newEvaluacionFerroviaria(@RequestBody EvaluacionFerroviariaDTO evaluacionFerroviariaDTO){

        return evaluacionFerroviaraService.newEvaluacionFerroviaria(evaluacionFerroviariaDTO);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionFerroviariaDTO> setEvaluacionFerroviariaID(@PathVariable Long id, @RequestBody EvaluacionFerroviariaDTO evaluacionFerroviariaDTO) {
       EvaluacionFerroviariaDTO evaluacionFerroviariaActualizada= evaluacionFerroviaraService.setEvaluacionFerroviariaID(id, evaluacionFerroviariaDTO);
       return ResponseEntity.ok(evaluacionFerroviariaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deteleEvaluacionFerroviariaById(@PathVariable Long id){

        evaluacionFerroviaraService.deteleEvaluacionFerroviariaById(id);
        return ResponseEntity.noContent().build();
    }
    
    



}
