package com.javaeeeee.dwstart.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.javaeeeee.dwstart.core.IndicadorCircular;

public class IndicadorCircularMapper implements ResultSetMapper<IndicadorCircular> {
	public IndicadorCircular map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
	    return new IndicadorCircular(r.getString("label"), 
	    		             r.getFloat("value")
	    		          );
	  }
}