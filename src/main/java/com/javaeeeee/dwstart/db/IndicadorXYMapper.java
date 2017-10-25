package com.javaeeeee.dwstart.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.javaeeeee.dwstart.core.IndicadorXY;

public class IndicadorXYMapper implements ResultSetMapper<IndicadorXY> {
	public IndicadorXY map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
	    return new IndicadorXY( r.getString("titulo"), 
	    		          		r.getFloat("valorX"), 
    		          			r.getFloat("valorY")
	    		          );
	  }
}
