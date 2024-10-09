package com.joseph.practicaCalificada02.servicios;

import com.joseph.practicaCalificada02.modelos.entidades.Alumno;

import java.util.List;

public interface AlumnoService {

    public List<Alumno> listar();

    public void grabar(Alumno alumno);

    public Alumno buscar(Integer id);

    public void eliminar(Integer id);

}



