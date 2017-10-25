package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.Archivo;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArchivoMapper implements ResultSetMapper<Archivo> {
    public Archivo map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Archivo(r.getInt("id_ticket"),
                r.getInt("id_renglon"),
                r.getString("nombre"),
                r.getString("extension"),
                r.getBytes("datos"));
    }
}
