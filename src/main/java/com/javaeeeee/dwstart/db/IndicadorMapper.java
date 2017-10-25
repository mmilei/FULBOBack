package com.javaeeeee.dwstart.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.javaeeeee.dwstart.core.Indicador;

public class IndicadorMapper implements ResultSetMapper<Indicador> {
	public Indicador map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
	    return new Indicador(r.getInt("id"), 
	    		             r.getString("titulo"), 
	    		             r.getString("descripcion"),
	    		             r.getFloat("valor")
	    		          );
	  }
}