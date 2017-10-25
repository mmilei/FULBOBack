package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.ContadorNotificaciones;
import com.javaeeeee.dwstart.core.Notificacion;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContadorNotificacionesMapper implements ResultSetMapper<ContadorNotificaciones> {
	public ContadorNotificaciones map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
	    return new ContadorNotificaciones (r.getInt("nuevas"));
	  }
}
