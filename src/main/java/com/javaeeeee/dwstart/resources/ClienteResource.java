package com.javaeeeee.dwstart.resources;

import com.javaeeeee.dwstart.core.Cliente;
import com.javaeeeee.dwstart.db.ClienteDAO;
import com.javaeeeee.dwstart.core.User;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ClienteResource {

    private ClienteDAO clienteDAO;

    public ClienteResource(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @GET
    @RolesAllowed({"ADMIN"})
    public Response getClientes(@Auth User user) {

        List<Cliente> clientes = clienteDAO.getClientes();

        if (clientes.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }

        //TODO
        return Response.ok(clientes).build();
    }

}
