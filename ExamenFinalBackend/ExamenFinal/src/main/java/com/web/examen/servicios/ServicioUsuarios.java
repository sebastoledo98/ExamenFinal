package com.web.examen.servicios;

import com.web.examen.business.GestionUsuario;
import com.web.examen.modelo.Usuario;

import java.util.List;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("usuarios")
public class ServicioUsuarios {
    
    @Inject
    private GestionUsuario gUsuarios;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Usuario usuario){
    	System.out.println(usuario);
        try{
            gUsuarios.guardarUsuario(usuario);
            ErrorMessage error = new ErrorMessage(1, "OK");
            //return Response.ok(usuario).build();
            return Response.status(Response.Status.CREATED)
                .entity(error)
                .build();
        }catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            		.entity(error)
            		.build();
         }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Usuario usuario){
        try{
            gUsuarios.guardarUsuario(usuario);
            return Response.ok(usuario).build();
        }catch (Exception e) {
        	ErrorMessage error = new ErrorMessage(99, e.getMessage());
        	return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            		.entity(error)
            		.build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String borrar(@QueryParam("id") int codigo){
        try{
            gUsuarios.borrarUsuario(codigo);
            return "OK";
        }catch (Exception e) {
            return "Error";
         }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response leer(@QueryParam("telefono")String telefono){
        try{
            System.out.println("telefono: " + telefono);
            if(telefono.length() < 10)
                throw new Exception("Telefono no valido");
            Usuario usr = gUsuarios.getUsuarioPorTelefono(telefono);
            if(usr == null)
                throw new Exception("No se encuentra un usuario registrado a ese telefono");
            System.out.println("usr = " + usr);
            ErrorMessage error = new ErrorMessage(1, "OK");
            return Response.status(Response.Status.OK)
                    .entity(error)
                    .build();
        }catch (Exception e) {
        	ErrorMessage error = new ErrorMessage(99, "Usuario no existe: " + e.getMessage());
        	return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            		.entity(error)
            		.build();
         }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response getUsuario(){
    	System.out.println("Listando");
    	List<Usuario> usuarios = gUsuarios.getUsuarios();
        System.out.println(usuarios);
    	if(usuarios.size() > 0)
    		return Response.ok(usuarios).build();
    	
    	ErrorMessage error = new ErrorMessage(6, "No se registran usuarios");
    	return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        		.entity(error)
        		.build();
    }

}
