package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.Cliente;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ClienteMapper.class)
public interface ClienteDAO {
    @SqlQuery("select cliente,nombre,nomabre,estado From sigo.vcli where emp = 1 order by nombre asc")
    List<Cliente> getClientes();
}
