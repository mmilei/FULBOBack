package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.core.Archivo;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


import java.util.List;

@RegisterMapper(ArchivoMapper.class)
public interface ArchivoDAO {
    @SqlQuery("select id_ticket,id_renglon,nombre,extension,datos from sigo.tbugs_archivo where id_ticket = :id_ticket ")
    List<Archivo> getAllByTicket(@Bind("id_ticket") int id_ticket);

    @SqlQuery("select id_ticket,id_renglon,nombre,extension,datos from sigo.tbugs_archivo where id_ticket = :id_ticket and id_renglon = :id_renglon")
    Archivo getByTicketRenglon(@Bind("id_ticket") int id_ticket,@Bind("id_renglon") int id_renglon);

    @SqlQuery("select a.id_ticket,a.id_renglon,a.nombre,a.extension,a.datos " +
            "  from sigo.tbugs_archivo a," +
            "       sigo.tbugs_new b " +
            "  where b.id = a.id_ticket " +
            "    and a.id_ticket = :id_ticket " +
            "    and b.cliente = :id_cliente " +
            "    and id_renglon = :id_renglon")
    Archivo getByTicketRenglonCliente(@Bind("id_ticket") int id_ticket,
                                      @Bind("id_renglon") int id_renglon,
                                      @Bind("id_cliente") int id_cliente);
/*
    @SqlUpdate("insert into sigo.tbugs_archivo (id_ticket,id_renglon,nombre,extension,datos)" +
            " values (:idTicket,(SELECT nvl(max(id_renglon),0)+1 from sigo.tbugs_archivo where id_ticket = :idTicket),
            :nombre,:extension,to_blob(UTL_ENCODE.base64_decode(UTL_RAW.cast_to_raw(:datos)))) ")
    void addArchivo(@BindBean Archivo archivo);
    */
    @SqlUpdate("insert into sigo.tbugs_archivo (id_ticket,id_renglon,nombre,extension,datos)" +
            " values (:idTicket,(SELECT nvl(max(id_renglon),0)+1 from sigo.tbugs_archivo where id_ticket = :idTicket)," +
            "substr(:nombre,1,100),:extension,:datosBlob) ")
    void addArchivo(@BindBean Archivo archivo);

    @SqlQuery("select id_ticket,id_renglon,nombre,extension,datos " +
            "  from sigo.tbugs_archivo a," +
            "       sigo.twrep b " +
            " where b.repid = :repid " +
            "   and a.id_ticket = b.parnum1 " +
            "   and a.id_renglon = b.parnum2 " +
            "   and rownum = 1")
    Archivo getByRepid(@Bind("repid") int repid);

    @SqlUpdate("delete from sigo.twrep where repid = :repid")
    void deleteRepid(@Bind("repid") int repid);

}
