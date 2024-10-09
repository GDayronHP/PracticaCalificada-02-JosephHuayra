package com.joseph.practicaCalificada02.servicios;

import com.joseph.practicaCalificada02.modelos.entidades.IAAnswers;

import java.util.List;

public interface IAAnswersService {

    public List<IAAnswers> listar();

    public void grabar(IAAnswers iaAnswers);

    public IAAnswers buscar(Integer id);

    public void eliminar(Integer id);

}



