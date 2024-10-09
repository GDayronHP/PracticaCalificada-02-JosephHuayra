package com.joseph.practicaCalificada02.modelos.daos;

import com.joseph.practicaCalificada02.modelos.entidades.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {
    // Ya tienes acceso a operaciones CRUD
}
