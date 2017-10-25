package com.javaeeeee.dwstart.resources;

import com.javaeeeee.dwstart.core.Archivo;
import com.javaeeeee.dwstart.core.User;
import com.javaeeeee.dwstart.db.ArchivoDAO;
import com.javaeeeee.dwstart.exception.ErrorMessage;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Base64;
import java.util.List;

@Path("/archivos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArchivoResource {

    private ArchivoDAO archivoDAO;

    public ArchivoResource(ArchivoDAO archivoDAO) {
        this.archivoDAO = archivoDAO;
    }

    @POST
    @RolesAllowed({"USER","ADMIN"})
    public Response uploadFileBase64(@Auth User user, Archivo archivo) {
        archivo.setDatosBlob(Base64.getDecoder().decode(archivo.getdatosBase64()));
        archivoDAO.addArchivo(archivo);
        return Response.ok().build();
    }

    @GET
    @RolesAllowed({"ADMIN"})
    @Path("/ticket/{id}")
    public Response getArchivos(@PathParam("id") int id, @Auth User user) {
        try {
            List<Archivo> archivos = archivoDAO.getAllByTicket(id);
            String datosBase64;

            // convierto a base64 el dato blob obtenido de la BD
            for (int i = 0; i < archivos.size(); i++) {
                if (archivos.get(i).getDatosBlob() != null) {
                    datosBase64 = new String(Base64.getEncoder().encode(archivos.get(i).getDatosBlob()), "UTF8");
                    archivos.get(i).setdatosBase64(datosBase64);
                }
            }
            if (archivos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMessage(404)).build();
            }

            return Response.ok(archivos).build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }

    @GET
    @RolesAllowed({"ADMIN"})
    @Path("/{id}/{renglon}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getArchivo(@PathParam("id") int id,
                               @PathParam("renglon") int renglon,
                               @Auth User user) {
        try {
            // obtengo blob
            Archivo archivo = archivoDAO.getByTicketRenglon(id,renglon);

            // genero un file para retornar
            File file = new File(archivo.getNombre());

            // retorno archivo para descarga
            return Response.ok(archivo.getDatosBlob(), MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                    .build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }


    @GET
    @RolesAllowed({"USER","ADMIN"})
    @Path("/ticket/{id}/{renglon}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getArchivoCliente(@PathParam("id") int id,
                                      @PathParam("renglon") int renglon,
                                      @Auth User user) {
        try {
            // obtengo blob
            Archivo archivo = archivoDAO.getByTicketRenglonCliente(id,renglon,user.getIdCliente());

            // genero un file para retornar
            File file = new File(archivo.getNombre());

            // retorno archivo para descarga
            return Response.ok(archivo.getDatosBlob(), MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                    .build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }
    @GET
    // puede acceder cualquier usuario, pero solo SIGO Cliente/servidor va a insertar en la repid para que funcione
    @Path("/sigocs/{repid}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    // recurso disponible solo para Sigo Cliente/servidor para poder descargar las imágenes
    public Response getArchivos(@PathParam("repid") int repid) {
        try {
            // obtengo blob
            Archivo archivo = archivoDAO.getByRepid(repid);

            // genero un file para retornar
            File file = new File(archivo.getNombre());

            // borro registro en twrep
            archivoDAO.deleteRepid(repid);

            // retorno archivo para descarga
            return Response.ok(archivo.getDatosBlob(), MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                    .build();
        } catch (Exception e) {
            throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }
    /*
    @GET
    //@Path("/sigocs/ticket/{id}/{renglon}")
    @Path("/sigocs")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    // recurso disponible solo para Sigo Cliente/servidor para poder descargar las imágenes
    public Response getArchivos(@PathParam("id") int id,
                                @PathParam("renglon") int idRenglon,
                                @QueryParam("token") String tokenSIGOCS) {
        String values = "24005|7|bafb1ee9-7a87-4680-a043-f1b0a914490e";

        String[] array = values.split("\\|", -1);
        System.out.println("EZE-DEBUG: ticket " + array[0]);
        System.out.println("EZE-DEBUG: id " + array[1]);
        System.out.println("EZE-DEBUG: token " + array[2]);

            if (tokenSIGOCS != null && tokenSIGOCS.equals("bafb1ee9-7a87-4680-a043-f1b0a914490e")) {
            Archivo archivo = archivoDAO.getByTicketRenglon(id,idRenglon);

            File file = new File(archivo.getNombre() + "." + archivo.getExtension());

                return Response.ok(archivo.getDatosBlob(), MediaType.APPLICATION_OCTET_STREAM)
                        .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                        .build();

            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorMessage(404)).build();
            }
    }
    */
    /*
    public static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }
    */
}
