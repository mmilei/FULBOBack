package com.javaeeeee.dwstart.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.javaeeeee.dwstart.core.Modulo;

public class ModuloMapper implements ResultSetMapper<Modulo> {
	public Modulo map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
	    return new Modulo(r.getString("codigo"), 
	    		          r.getString("nombre"));
	  }
}
