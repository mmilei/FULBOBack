package com.javaeeeee.dwstart.resources;

import com.javaeeeee.dwstart.core.ContadorNotificaciones;
import com.javaeeeee.dwstart.core.Notificacion;
import com.javaeeeee.dwstart.core.Ticket;
import com.javaeeeee.dwstart.core.User;
import com.javaeeeee.dwstart.db.NotificacionDAO;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notificaciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class NotificacionResource {
    private NotificacionDAO notificacionDAO;

    public NotificacionResource(NotificacionDAO notificacionDAO) {
        this.notificacionDAO = notificacionDAO;
    }

    @GET
    @RolesAllowed({"USER","ADMIN"})
    public Response getAll(@Auth User user) {
        try {
            List<Notificacion> notificaciones = notificacionDAO.getAll(user.getIdCliente());
            return Response.ok(notificaciones).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @RolesAllowed({"USER","ADMIN"})
    @Path("/nuevas")
    public Response getNotificacionesNoLeidas(@Auth User user) {
        try {
            ContadorNotificaciones contadorNotificaciones = notificacionDAO.getNotificacionesNoLeidas(user.getIdCliente());
            if (contadorNotificaciones == null) {
                throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
            }
            return Response.ok(contadorNotificaciones).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    @PUT
    @RolesAllowed({"USER","ADMIN"})
    @Path("/leidas")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response resetPassword (@Auth User user) {
        try {
            notificacionDAO.setNotificacionesLeidas(user.getIdCliente());
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
