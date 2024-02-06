package com.web.examen.servicios;

import com.web.examen.business.GestionUsuario;
import com.web.examen.modelo.*;
import java.util.Random;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("recargar")
public class ServicioTransacciones{

    @Inject
    private GestionUsuario gUsuarios;

    private Random random = new Random();

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response realizarRecarga(Transaccion transaccion){
        try{
            System.out.println(transaccion);
            if(transaccion.getMonto() < 1)
                throw new Exception("El monto de la recarga debe ser de almenos 1 dolar");
            if(transaccion.getTelefono().length() < 10)
                throw new Exception("Numero de telefono no valido");
            Usuario usr = gUsuarios.getUsuarioPorTelefono(transaccion.getTelefono());
            if(usr == null){
                throw new Exception("Usuario no existe");
            }
            boolean flag = random.nextBoolean();
            System.out.println("Bandera: " + flag);
            if(flag)
                throw new Exception("Error al realizar la recarga, intente mas tarde");
            usr.setSaldo(usr.getSaldo() + transaccion.getMonto());
            gUsuarios.actualizarUsuario(usr);
            ErrorMessage error = new ErrorMessage(1, "OK");
            return Response.status(Response.Status.OK)
                .entity(error)
                .build();
        }catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }

}
