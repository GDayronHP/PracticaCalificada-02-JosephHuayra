package com.joseph.practicaCalificada02.servicios;

import com.joseph.practicaCalificada02.modelos.daos.IAAnswersRepository;
import com.joseph.practicaCalificada02.modelos.entidades.IAAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IAAnswersServiceImpl implements IAAnswersService {
    @Autowired
    private IAAnswersRepository dao;

    @Override
    @Transactional(readOnly = false)
    public void grabar(IAAnswers iaAnswers) {
        dao.save(iaAnswers);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public IAAnswers buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IAAnswers> listar() {
        return (List<IAAnswers>)dao.findAll();
    }
}


