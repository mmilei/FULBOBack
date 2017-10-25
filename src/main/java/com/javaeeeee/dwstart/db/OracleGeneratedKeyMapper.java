package com.javaeeeee.dwstart.db;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleGeneratedKeyMapper implements ResultSetMapper<Long> {

    @Override
    public Long map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return r.getLong(1);
    }
}
