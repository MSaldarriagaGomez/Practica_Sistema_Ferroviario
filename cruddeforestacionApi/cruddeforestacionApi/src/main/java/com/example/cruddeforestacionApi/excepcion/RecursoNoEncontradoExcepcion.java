package com.example.cruddeforestacionApi.excepcion;


//para crear excepcions personalizadas sobre cosas no encontradas
public class RecursoNoEncontradoExcepcion extends RuntimeException{
    

    //private static final long serialVersionID=1L;

    public RecursoNoEncontradoExcepcion(String mensaje){
        super(mensaje);
    }
}
