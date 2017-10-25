package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.Calificacion;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(CalificacionMapper.class)
public interface CalificacionDAO {

    @SqlUpdate("INSERT INTO sigo.tcalificacion (id,puntaje,comentario,fecha,ticket,empproy,codproy,usuarioweb) " +
            " VALUES ((SELECT nvl(max(id),0)+1 FROM sigo.tcalificacion),:puntaje,:comentario," +
            " to_date(:fecha,'dd/mm/yyyy'), :idTicket, :proyectoEmpresa, :proyectoCodigo, :usuario)")
    @GetGeneratedKeys(columnName = "id", value = OracleGeneratedKeyMapper.class)
    int insertarCalificacion(@BindBean Calificacion calificacion);

    @SqlQuery("SELECT id,puntaje,comentario,to_char(fecha,'dd/mm/yyyy') as fecha,ticket,empproy,codproy,usuarioweb " +
              "  FROM sigo.tcalificacion " +
              " WHERE ticket = :idTicket")
    Calificacion getCalificacionByTicket(@Bind("idTicket") int idTicket);

    @SqlQuery("SELECT id,puntaje,comentario,to_char(fecha,'dd/mm/yyyy') as fecha,ticket,empproy,codproy,usuarioweb " +
            "  FROM sigo.tcalificacion " +
            " WHERE empproy = 1 " +
            "   AND codproy = :codigoProyecto")
    Calificacion getCalificacionByProyecto(@Bind("codigoProyecto") int codigoProyecto);

}
