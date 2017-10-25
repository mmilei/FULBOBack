package com.javaeeeee.dwstart.resources;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javaeeeee.dwstart.core.Indicador;
import com.javaeeeee.dwstart.core.IndicadorCircular;
import com.javaeeeee.dwstart.core.IndicadorXY;
import com.javaeeeee.dwstart.core.User;
import com.javaeeeee.dwstart.db.IndicadorDAO;
import com.javaeeeee.dwstart.exception.ErrorMessage;
import io.dropwizard.auth.Auth;

@Path("/indicadores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class IndicadorResource {

    private IndicadorDAO indicadorDAO;

    public IndicadorResource(IndicadorDAO indicadorDAO) {
        this.indicadorDAO = indicadorDAO;
    }

    @GET
    @RolesAllowed({"USER","ADMIN"})
    public Response getIndicadoresEscalares(@Auth User user) {
        try {
        	List<Indicador> indicadores = indicadorDAO.getIndicadoresEscalaresByCliente(user.getIdCliente());
            if (indicadores.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMessage(404)).build();
            }
            return Response.ok(indicadores).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }        
    }
    
    @GET
    @RolesAllowed({"USER","ADMIN"})
    @Path("/circular")
    public Response getIndicadorCircular(@Auth User user) {
        try {
        	List<IndicadorCircular> indicadores = indicadorDAO.getIndicadorCircularByCliente(user.getIdCliente());
            if (indicadores.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMessage(404)).build();
            }

            return Response.ok(indicadores).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }        
    }
    
    @GET
    @RolesAllowed({"USER","ADMIN"})
    @Path("/barras")
    public Response getIndicadorBarras(@Auth User user) {
        try {
        	List<IndicadorXY> indicadores = indicadorDAO.getIndicadorBarrasByCliente(user.getIdCliente());
            if (indicadores.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMessage(404)).build();
            }
            return Response.ok(indicadores).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }        
    }   
    
    @GET
    @RolesAllowed({"USER","ADMIN"})
    @Path("/lineas")
    public Response getIndicadorLineas(@Auth User user) {
        try {
        	List<IndicadorXY> indicadores = indicadorDAO.getIndicadorLineasByCliente(user.getIdCliente());

            if (indicadores.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMessage(404)).build();
            }

        	return Response.ok(indicadores).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }
    /*
    @Path("/cliente/{id}")
    @GET
    public Response getIndicadoresEscalaresByCliente(@PathParam("id") int id) {
        try {
        	List<Indicador> indicadores = indicadorDAO.getIndicadoresEscalaresByCliente(id);
        	return Response.ok(indicadores).build();
            	} catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
    }
    
    @Path("/circular/cliente/{id}")
    @GET
    public Response getIndicadorCircularByCliente(@PathParam("id") int id) {
        try {
        	List<IndicadorCircular> indicadores = indicadorDAO.getIndicadorCircularByCliente(id);
        	return Response.ok(indicadores).build();
            	} catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
    }
    
    @Path("/barras/cliente/{id}")
    @GET
    public Response getIndicadorBarrasByCliente(@PathParam("id") int id) {
        try {
        	List<IndicadorXY> indicadores = indicadorDAO.getIndicadorBarrasByCliente(id);
        	return Response.ok(indicadores).build();
            	} catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
    }   
    
    @Path("/lineas/cliente/{id}")
    @GET
    public Response getIndicadorLineasByCliente(@PathParam("id") int id) {
        try {
        	List<IndicadorXY> indicadores = indicadorDAO.getIndicadorLineasByCliente(id);
        	return Response.ok(indicadores).build();
            	} catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
    }
     */
}    
