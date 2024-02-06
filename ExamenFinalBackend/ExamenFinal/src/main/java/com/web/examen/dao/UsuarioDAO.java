package com.web.examen.dao;

import jakarta.ejb.Stateless;

import java.util.List;
import com.web.examen.modelo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Usuario usuario){
        em.persist(usuario);
    }

    public void update(Usuario usuario){
        em.merge(usuario);
    }

    public void remove(int codigo){
        Usuario usuario = em.find(Usuario.class, codigo);
        em.remove(usuario);
    }

    public Usuario read(int codigo){
        Usuario usuario = em.find(Usuario.class, codigo);
        return usuario;
    }

    public Usuario getUsuarioPorTelefono(String telefono) {
        String sentencia = "SELECT u FROM Usuario u WHERE u.telefono = :telefono";
        Query q = em.createQuery(sentencia, Usuario.class);
        q.setParameter("telefono",telefono);
        List<Usuario> usuarios = q.getResultList();
        if(usuarios.size() > 0)
            return usuarios.get(0);
        return null;
    }

    public List<Usuario> getAll(){
        String sentencia = "SELECT p FROM Usuario p";
        Query q = em.createQuery(sentencia, Usuario.class);
        return q.getResultList();
    }

}
