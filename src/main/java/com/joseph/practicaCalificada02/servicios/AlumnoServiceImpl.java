package com.joseph.practicaCalificada02.servicios;

import com.joseph.practicaCalificada02.modelos.daos.AlumnoRepository;
import com.joseph.practicaCalificada02.modelos.entidades.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository dao;

    @Override
    @Transactional(readOnly = false)
    public void grabar(Alumno alumno) {
        dao.save(alumno);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public Alumno buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> listar() {
        return (List<Alumno>)dao.findAll();
    }
}

