package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.Calificacion;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalificacionMapper implements ResultSetMapper<Calificacion> {
    public Calificacion map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Calificacion(r.getInt("id"),
                                r.getInt("puntaje"),
                                r.getString("comentario"),
                                r.getInt("ticket"),
                                r.getInt("empproy"),
                                r.getInt("codproy"),
                                r.getString("usuarioweb"),
                                r.getString("fecha")
                );
    }
}
