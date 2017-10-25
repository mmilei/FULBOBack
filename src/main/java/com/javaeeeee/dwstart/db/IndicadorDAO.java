package com.javaeeeee.dwstart.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.javaeeeee.dwstart.core.Indicador;
import com.javaeeeee.dwstart.core.IndicadorCircular;
import com.javaeeeee.dwstart.core.IndicadorXY;


@RegisterMapper(IndicadorMapper.class)
public interface IndicadorDAO {
	/**
	  * Indicador 1: Cantidad de tickets abiertos (histórico)
	  * Indicador 2: Efectividad, Tickets cerrados sobre el total de tickets ingresados desde el 2016 hasta
	  * el mes anterior. Se toman en cuenta todos los tipo de tickets menos 3	Mejora (uso Interno SVN), 6 Cotizacion, 9 Mejora (Producto)
	  * Indicador 3: Tiempo de Respuesta. Tiempo transcurrido en horas desde el ingreso de un ticket el primer contacto con el cliente
	  * No se toman en cuenta fines de semana, los movimientos posteriores a las 18 pasan al siguiente día.
	  * Indicador 4: Tiempo de cierre. Promedio de días transcurridos desde apertura hasta cierre del ticket, desde el 2016 hasta el 
	  * mes anterior, Se toman en cuenta todos los tipo de tickets menos 3	Mejora (uso Interno SVN), 6 Cotizacion, 9 Mejora (Producto)
	  * 
	  */
	@SqlQuery("SELECT 1 as id,'Indicador 1' as titulo, 'Cantidad de tickets en estado abierto' as descripcion, COUNT (*) AS valor " +
			"  FROM sigo.tbugs_new " + 
			" WHERE     cliente = :cliente " + 
			"       AND estado = 1 " +
			"UNION       " + 
			"SELECT 2 AS id, " + 
			"       'Indicador 2' AS titulo, " + 
			"       'Porcentaje de tickets abiertos sobre ingresados' AS descripcion, " + 
			"         round(DECODE ( " + 
			"            tkt_ing_total.cantidad, " + 
			"            0, 0, " + 
			"            tkt_cerrados_total_vigente.cantidad / tkt_ing_total.cantidad) " + 
			"       * 100) " + 
			"          AS valor " + 
			"  FROM (SELECT COUNT (*) AS cantidad " + 
			"          FROM sigo.tbugs_new " + 
			"         WHERE     cliente = :cliente " + 
			"               AND TO_NUMBER (TO_CHAR (entrada_planilla, 'rrrr')) = TO_NUMBER (TO_CHAR (sysdate, 'rrrr')) " + 
			"               AND tipoinci NOT IN (3,6,9)) tkt_ing_total, " + 
			"       (SELECT COUNT (*) AS cantidad " + 
			"          FROM sigo.tbugs_new " + 
			"         WHERE     cliente = :cliente " + 
			"               AND TO_NUMBER (TO_CHAR (entrada_planilla, 'rrrr')) = TO_NUMBER (TO_CHAR (sysdate, 'rrrr')) " + 
			"               AND estado = 8 " +
			"               AND tipoinci NOT IN (3,6,9)) tkt_cerrados_total_vigente " +
			"UNION " +
			"SELECT 3 AS id,   " +
			"       'Indicador 3' AS titulo,   " +
			"       'Tiempo de Respuesta' AS descripcion,   " +
			"       NVL (ROUND (AVG (horas)), 0) AS valor   " +
			"  FROM ( " +
			"        SELECT TRUNC (avg(horas_contacto_cliente)) AS horas   " +
			"          FROM sigo.tbugs_new   " +
			"         WHERE     horas_contacto_cliente IS NOT NULL   " +
			"               AND entrada_planilla > TO_DATE ('01012017', 'ddmmyyyy')   " +
			"               AND cliente = :cliente   " +
			"               AND tipoinci NOT IN (3, 6, 9))" +
			"UNION " +
            " SELECT 4, 'Indicador 4' as titulo, 'Promedio de resolución de tickets' as descripcion, round(avg(dias_totales - dias_cliente)*0.7) as valor " +
            " from ( " +
            " select round(avg(fecha_cierre - entrada_planilla)) as dias_totales, " +
            "       round(sum(nvl(fecha_salida_cliente,fecha_cierre) - nvl(fecha_entrada_cliente,fecha_cierre))) as dias_cliente " +
            "               from (  " +
            "               select a.id, " +
            "                      trunc(a.entrada_planilla) as entrada_planilla, " +
            "                      trunc(b.fecha_entrada) as fecha_entrada_cliente,  " +
            "                      (select trunc(c.fecha_entrada) from sigo.trenbugs_new c where c.id = b.id and c.renglon = b.renglon + 1) as fecha_salida_cliente, " +
            "                      trunc(a.fecha_cierre) as fecha_cierre " +
            "               from sigo.tbugs_new a left join sigo.TRENBUGS_NEW b on a.id = b.id and upper(b.tarea_realizada) = 'EN PODER DEL CLIENTE'  " +
            "               where  TO_NUMBER(TO_CHAR (a.entrada_planilla, 'rrrr')) >= 2016    " +
            "                 AND a.estado = 8 " +
            "                 AND a.origeninci = 1 " +
            "                 AND a.tipoinci NOT IN (3,6,9) " +
            "                 AND a.cliente = :cliente " +
            "               ) " +
            "group by id,entrada_planilla,fecha_cierre " +
            ")"
    )
    List<Indicador> getIndicadoresEscalaresByCliente(@Bind("cliente") int cliente);
	
	/**
	  * Indicador Circular: Tipos de ticket por cliente en estado cerrado. Histórico.
	  *  Se renombra "Correccion de fallas" por "Corrección y Mejoras" solo para Sigo WEB.
	  * 
	  */
	@RegisterMapper(IndicadorCircularMapper.class)
	@SqlQuery("SELECT descripcion as label, " + 
			"       porcentaje as value " + 
			"  FROM (  SELECT decode(b.tipoinci,1,'Corrección y Mejoras',b.nombre) AS descripcion, COUNT (*) AS valor, round(100*(count(*) / sum(count(*)) over ()),1) as porcentaje " +
			"            FROM sigo.tbugs_new a, sigo.ttipos_inci b " + 
			"           WHERE a.tipoinci = b.tipoinci AND cliente = :cliente AND a.estado = 8 " +
			"             AND TO_CHAR (a.fecha_cierre, 'rrrr') = TO_CHAR (SYSDATE, 'rrrr') " +
			"        GROUP BY b.tipoinci, b.nombre " +
			"        ORDER BY b.nombre) "
			)
    List<IndicadorCircular> getIndicadorCircularByCliente(@Bind("cliente") int cliente);
	
	/**
	  * Indicador Barras: Cantidad de tickets ingresados vs cantidad de tickets cerrados en cada mes del año vigente
	  * 
	  */
	@RegisterMapper(IndicadorXYMapper.class)
	@SqlQuery("select substr(titulo,1,3) as titulo, valorX, valorY " +
			"from (      " + 
			"select a.id, a.titulo,sum(a.valorx) as valorX,sum(a.valory) as valorY      " + 
			"from (select TO_CHAR (a.entrada_planilla, 'mm') as id, b.nombre titulo, count(*) valorX, null as valorY      " + 
			"FROM sigo.tbugs_new a, condor.tcodvalo b      " + 
			"WHERE cliente = :cliente      " + 
			"AND b.idioma = 'ESP'      " + 
			"AND b.codval = 15      " + 
			"AND lpad(b.codigo,2,'0') = TO_CHAR(a.entrada_planilla, 'mm')      " + 
			"AND TO_CHAR (a.entrada_planilla, 'rrrr') = TO_CHAR (SYSDATE, 'rrrr')      " + 
			"group by TO_CHAR (a.entrada_planilla, 'rrrr'),TO_CHAR (a.entrada_planilla, 'mm'),b.codigo,b.nombre      " + 
			"union      " + 
			"select TO_CHAR (a.fecha_cierre, 'mm') as id, b.nombre titulo, null as valorX,count(*) valorY      " + 
			"FROM sigo.tbugs_new a, condor.tcodvalo b              " + 
			"WHERE cliente = :cliente      " + 
			"AND b.idioma = 'ESP'      " + 
			"AND b.codval = 15      " + 
			"AND lpad(b.codigo,2,'0') = TO_CHAR(a.fecha_cierre, 'mm')      " + 
			"AND TO_CHAR (a.fecha_cierre, 'rrrr') = TO_CHAR (SYSDATE, 'rrrr')      " + 
			"group by TO_CHAR (a.fecha_cierre, 'rrrr'),TO_CHAR (a.fecha_cierre, 'mm'),b.codigo,b.nombre      " + 
			") a     " + 
			"group by a.id, a.titulo      " + 
			"order by a.id asc      " + 
			")"
			)
    List<IndicadorXY> getIndicadorBarrasByCliente(@Bind("cliente") int cliente);
	
	/**
	  * Indicador Lineas: Cantidad de tickets ingresados vs cantidad de tickets cerrados por año
	  * 
	  */	
	@RegisterMapper(IndicadorXYMapper.class)
	 @SqlQuery("SELECT titulo,     " + 
	 		"sum(valorX) as valorX, " + 
	 		"sum(valorY) as valorY      " + 
	 		"FROM (  SELECT TO_CHAR (entrada_planilla, 'rrrr') AS titulo,      " + 
	 		"COUNT (*) AS valorX, " + 
	 		"null as valorY " + 
	 		"FROM sigo.tbugs_new      " + 
	 		"WHERE entrada_planilla IS NOT NULL AND cliente = :cliente      " + 
	 		"GROUP BY TO_CHAR (entrada_planilla, 'rrrr')      " + 
	 		"UNION      " + 
	 		"SELECT TO_CHAR (fecha_cierre, 'rrrr') AS titulo,    " + 
	 		"null as valorX, " + 
	 		"COUNT (*) AS valorY " + 
	 		"FROM sigo.tbugs_new      " + 
	 		"WHERE fecha_cierre IS NOT NULL AND cliente = :cliente AND estado = 8      " + 
	 		"GROUP BY TO_CHAR (fecha_cierre, 'rrrr')) " + 
	 		"group by titulo " + 
	 		"order by titulo  ")
   List<IndicadorXY> getIndicadorLineasByCliente(@Bind("cliente") int cliente);
}
