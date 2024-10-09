package com.joseph.practicaCalificada02.servicios;

import com.joseph.practicaCalificada02.modelos.entidades.IAQuestion;

import java.util.List;

public interface IAQuestionService {

    public List<IAQuestion> listar();

    public void grabar(IAQuestion iaQuestion);

    public IAQuestion buscar(Integer id);

    public void eliminar(Integer id);

}



