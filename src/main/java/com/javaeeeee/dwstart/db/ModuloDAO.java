package com.javaeeeee.dwstart.db;

        import java.util.List;

        import org.skife.jdbi.v2.sqlobject.Bind;
        import org.skife.jdbi.v2.sqlobject.SqlQuery;
        import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

        import com.javaeeeee.dwstart.core.Modulo;

@RegisterMapper(ModuloMapper.class)
public interface ModuloDAO {
    @SqlQuery("select codigo,nombre from sigoweb.vmodulos where producto = 'condor' order by nombre ASC")
    List<Modulo> getAll();

    @SqlQuery(" SELECT '' as codigo, descripcion as nombre FROM ( " +
            " SELECT estadobi,estadoce,estadoco,estadofi,estadopa,estadoge,estadocp,estadove, " +
            "        estadost, estadocm, estadofa, estadorh, estadolh, estadocu " +
            "   FROM sigo.tclisigo a " +
            "WHERE a.cliente = :cliente and base = :base AND a.estado = 0 " +
            ") " +
            "UNPIVOT ( modulo_flag FOR descripcion IN ( ESTADOBI as 'BI',  " +
            "                                           ESTADOCE AS 'Central', " +
            "                                           ESTADOCO AS 'Contabilidad', " +
            "                                           ESTADOFI AS 'Finanzas', " +
            "                                           ESTADOPA AS 'Pagos', " +
            "                                           ESTADOGE AS 'Gestión', " +
            "                                           ESTADOCP AS 'Compras', " +
            "                                           ESTADOVE AS 'Ventas', " +
            "                                           ESTADOST AS 'Stock', " +
            "                                           ESTADOCM AS 'Comercial', " +
            "                                           ESTADOFA AS 'Facturación', " +
            "                                           ESTADORH AS 'RRHH', " +
            "                                           ESTADOLH AS 'Haberes', " +
            "                                           ESTADOCU AS 'Customs')) " +
            "where modulo_flag = 1 ")
    List<Modulo> getModuloPorProducto(@Bind("cliente") int cliente, @Bind("base") String base);
}
