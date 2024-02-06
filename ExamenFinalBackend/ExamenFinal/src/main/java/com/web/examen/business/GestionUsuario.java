package com.web.examen.business;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import com.web.examen.modelo.Usuario;
import com.web.examen.dao.UsuarioDAO;

@Stateless
public class GestionUsuario {

    @Inject
    private UsuarioDAO usuarioDao;

    public void guardarUsuario(Usuario usuario){
    	System.out.println("usuario = " + usuario);
        Usuario per = usuarioDao.read(usuario.getId());
        System.out.println("per = " + per);
        if(per == null)
        	usuarioDao.insert(usuario);
        else
            usuarioDao.update(usuario);
    }
    
    public void actualizarUsuario(Usuario usuario) throws Exception{
    	Usuario per = usuarioDao.read(usuario.getId());
    	if(per != null) 
    		usuarioDao.update(usuario);
		else
			throw new Exception("Usuario no existe");
    }

    public Usuario getUsuarioPorTelefono(String telefono) throws Exception{
        if(telefono.length() < 10)
            throw new Exception("Telefono incorrecto");
        return usuarioDao.getUsuarioPorTelefono(telefono);
    }

    public void borrarUsuario(int id){
        usuarioDao.remove(id);
    }

    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = usuarioDao.getAll();
        System.out.println(usuarios);
        return usuarios;
    }

}
