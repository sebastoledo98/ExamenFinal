package com.web.examen.dao;

import jakarta.ejb.Stateless;

import java.util.List;
import com.web.examen.modelo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO{

    @PersistenceContext
    private EntityManager em;

}
