package com.javaeeeee.dwstart.resources;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javaeeeee.dwstart.core.Modulo;
import com.javaeeeee.dwstart.core.User;
import com.javaeeeee.dwstart.db.ModuloDAO;
import io.dropwizard.auth.Auth;

@Path("/modulos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ModuloResource {
	private ModuloDAO moduloDAO;

    public ModuloResource(ModuloDAO moduloDAO) {
        this.moduloDAO = moduloDAO;
    }
    
    @GET
    @RolesAllowed({"USER","ADMIN"})
    public Response listModulos(@Auth User user) {
        try {
        	List<Modulo> modulos = moduloDAO.getAll();
        	return Response.ok(modulos).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }
}
