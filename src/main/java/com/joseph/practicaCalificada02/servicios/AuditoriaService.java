package com.joseph.practicaCalificada02.servicios;

import com.joseph.practicaCalificada02.modelos.entidades.Auditoria;

import java.util.List;

public interface AuditoriaService {
    void grabar(Auditoria auditoria);
    void eliminar(Integer id);
    Auditoria buscar(Integer id);
    List<Auditoria> listar();
}
