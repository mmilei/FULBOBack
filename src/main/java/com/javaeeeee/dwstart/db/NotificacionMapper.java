package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.Notificacion;
import com.javaeeeee.dwstart.core.Ticket;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificacionMapper implements ResultSetMapper<Notificacion> {
	public Notificacion map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
	    return new Notificacion(r.getInt("id"),
								r.getInt("id_cliente"),
								r.getString("titulo"),
								r.getString("descripcion"),
								r.getString("fecha_carga"),
								r.getString("leido")
								);
	  }
}
