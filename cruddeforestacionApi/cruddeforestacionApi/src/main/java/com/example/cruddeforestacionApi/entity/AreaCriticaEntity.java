package com.example.cruddeforestacionApi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


//entidad es un objeto que se va a convertir en una tabla de la base de datos
@Entity
@Table(name="areas_criticas")
//clase es la tabla, las variables son las columnas, y los objetos que creamos son las filas
public class AreaCriticaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Size(min= 2, max=100)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    @Size(min= 10, max=500)
    private String descripcion;

    @NotNull
    @Column(nullable = false)
    private Double latitud;

    @NotNull
    @Column(nullable = false)
    private Double longitud;
    

    @Column(name= "indice_deforestacion")
    private Double indiceDeforestacion;

    @OneToMany(mappedBy = "areaCriticaEntity", cascade = CascadeType.ALL)
    private List<EvaluacionFerroviariaEntity> evaluacionFerroviariaEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getIndiceDeforestacion() {
        return indiceDeforestacion;
    }

    public void setIndiceDeforestacion(Double indiceDeforestacion) {
        this.indiceDeforestacion = indiceDeforestacion;
    }

    public List<EvaluacionFerroviariaEntity> getEvaluacionFerroviariaEntities() {
        return evaluacionFerroviariaEntities;
    }

    public void setEvaluacionFerroviariaEntities(List<EvaluacionFerroviariaEntity> evaluacionFerroviariaEntities) {
        this.evaluacionFerroviariaEntities = evaluacionFerroviariaEntities;
    } 

    
}