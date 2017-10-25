package com.javaeeeee.dwstart.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaeeeee.dwstart.core.AccessToken;
import com.javaeeeee.dwstart.core.User;
import com.javaeeeee.dwstart.db.AccessTokenDAO;
import com.javaeeeee.dwstart.db.UserDAO;
import com.google.common.base.Optional;
import io.dropwizard.auth.Auth;
import org.joda.time.DateTime;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class OAuthResource {
    private AccessTokenDAO accessTokenDAO;
    private UserDAO userDAO;

    public OAuthResource(AccessTokenDAO accessTokenDAO, UserDAO userDAO) {
        this.accessTokenDAO = accessTokenDAO;
        this.userDAO = userDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postForToken(@FormParam("username") String username,
                               @FormParam("password") String password) {
        try {
            // busco en la base de datos el usuario
            User user = userDAO.getUserByUsernameAndPassword(username, password);
            System.out.println("DEBUG: Inicio sesión " + username);
            // si lo encontré, genero un token
            AccessToken accessToken = accessTokenDAO.generateNewAccessToken(user, DateTime.now());
            //return accessToken.getToken().toString();
            user.setToken(accessToken.getToken().toString());

            // creo un mapper para retornar un JSON de la clase AccessToken
            /*
            ObjectMapper mapper = new ObjectMapper();
            String jsonAccessToken = mapper.writeValueAsString(accessToken);
            return Response.ok(jsonAccessToken).build();
            */
            return Response.ok(user).build();

            //return Response.ok(jsonAccessToken).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    @PUT
    @RolesAllowed({"USER","ADMIN"})
    @Path("/password-change")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response resetPassword (@Auth User user,
                                   @FormParam("new-password") String newPassword) {
        try {
            userDAO.cambiarPassword(user.getId(), newPassword);

            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

}
