package com.joseph.practicaCalificada02.servicios;

import com.joseph.practicaCalificada02.modelos.daos.IAQuestionRepository;
import com.joseph.practicaCalificada02.modelos.entidades.IAQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IAQuestionServiceImpl implements IAQuestionService {
    @Autowired
    private IAQuestionRepository dao;

    @Override
    @Transactional(readOnly = false)
    public void grabar(IAQuestion iaQuestion) {
        dao.save(iaQuestion);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public IAQuestion buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IAQuestion> listar() {
        return (List<IAQuestion>)dao.findAll();
    }
}


