package com.web.examen.business;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import java.util.List;

import com.web.examen.dao.*;

import com.web.examen.modelo.*;

@Singleton
@Startup
public class GestionDatos {
    @Inject
    private UsuarioDAO usuarioDAO;
    @Inject
    private RecargaDAO recrgaDao;

    @PostConstruct
    public void init(){
        System.out.println("iniciando");
        //Usuario 1
        Usuario usuario = new Usuario();
        usuario.setTelefono("0123456789");
        usuario.setOperadora("CNT");
        usuario.setSaldo(10.00);
        usuarioDAO.insert(usuario);
        //Usuario 2
        usuario = new Usuario();
        usuario.setTelefono("0987654321");
        usuario.setOperadora("Claro");
        usuario.setSaldo(25.00);
        usuarioDAO.insert(usuario);
        //Usuario 3
        usuario = new Usuario();
        usuario.setTelefono("0986532147");
        usuario.setOperadora("Movistar");
        usuario.setSaldo(5.00);
        usuarioDAO.insert(usuario);
        /*
        //Listar Usuarios
        List<Usuario> lista = usuarioDAO.getAll();
        for(Usuario c : lista){
            System.out.print(c.getId() + "\n");
            System.out.print(c.getDni() + "\n");
            System.out.print(c.getDireccion() + "\n");
            System.out.print(c.getNombre() + "\n");
        }
        */

        System.out.println("--------------Usuarios--------------");
        List<Usuario> usuarios = usuarioDAO.getAll();
        for(Usuario p: usuarios){
            System.out.println(p);
        }

    }
}
