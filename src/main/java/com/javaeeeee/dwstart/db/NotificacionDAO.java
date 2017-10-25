package com.javaeeeee.dwstart.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaeeeee.dwstart.core.ContadorNotificaciones;
import com.javaeeeee.dwstart.core.Notificacion;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(NotificacionMapper.class)
public interface NotificacionDAO {
    @SqlQuery("select id,id_cliente,titulo,descripcion,fecha_carga,leido from sigoweb.tnotificacion where id_cliente = :cliente order by id DESC")
    List<Notificacion> getAll(@Bind("cliente") int cliente);

    @SqlUpdate("update sigoweb.tnotificacion set leido = 'S' where id_cliente = :cliente and leido = 'N'")
    void setNotificacionesLeidas(@Bind("cliente") int cliente);

    @RegisterMapper(ContadorNotificacionesMapper.class)
    @SqlQuery("select count(*) as nuevas from sigoweb.tnotificacion where id_cliente = :cliente and leido = 'N'")
    ContadorNotificaciones getNotificacionesNoLeidas(@Bind("cliente") int cliente);
}
