package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.Cliente;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper implements ResultSetMapper<Cliente> {
        public Cliente map(int index, ResultSet r, StatementContext ctx) throws SQLException
        {
            return new Cliente(r.getInt("cliente"),
                    r.getString("nombre"),
                    r.getString("nomabre"),
                    r.getInt("estado"));
        }
    }