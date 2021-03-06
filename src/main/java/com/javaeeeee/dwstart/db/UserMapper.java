package com.javaeeeee.dwstart.db;


import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.javaeeeee.dwstart.core.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {
	public User map(int index, ResultSet r, StatementContext ctx) throws SQLException
	  {
		  return new User(r.getInt("id"),
	    		          r.getString("usuario"),
	    		          r.getString("nombre"),
	    		          r.getString("apellido"),
	    		          r.getString("email"),
	    		          r.getString("telefono"),
				          r.getInt("id_cliente"),
				          r.getString("rol")
	    		          );
	  }
}
