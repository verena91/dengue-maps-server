package py.una.pol.denguemaps.constant;

/*
 * Esta clase cuenta con todas las constantes del sistema.
 * 
 */
public class Statics {

	/** QUERYS **/
	public final static String RIESGOSASU = "with notif (barrio, departamento, semana, cantidad) as "
			+ " (select noti.barrio, noti.departamento, CAST(coalesce(noti.semana, '0') AS integer) as semana, count(*) as cantidad from notificacion noti where anio='{0}' "
			+ "	and semana not like '999' and noti.departamento = 'ASUNCION' group by barrio,departamento, semana order by CAST(coalesce(noti.semana, '0') AS integer), barrio), "
			+ " cuartiles (barrio, area, cuartil_uno, cuartil_dos, cuartil_tres) as"
			+ " (select barrio, area, CAST(coalesce(cuartil_uno, '0') AS integer), CAST(coalesce(cuartil_dos, '0') AS integer), CAST(coalesce(cuartil_tres, '0') AS integer) from cuartiles_por_barrio)"
			+ " select n.departamento || '-' ||n.barrio as barrio, n.semana, n.cantidad,"
			+ " (CASE WHEN n.cantidad <= c.cuartil_uno THEN 'RB' "
			+ "	WHEN n.cantidad <= c.cuartil_dos THEN 'RM'"
			+ "	WHEN n.cantidad <= c.cuartil_tres THEN 'RA'"
			+ "	ELSE 'E' END ) as riesgo "
			+ " from notif n left join cuartiles c on (n.barrio = c.barrio)";
	
	public final static String REISGOSDITRITOS = "with notif (departamento,distrito, semana, cantidad) as"+
			" (select noti.departamento, noti.distrito, CAST(coalesce(noti.semana, '0') AS integer) as semana, count(*) as cantidad from notificacion noti where anio='{0}' and departamento != 'ASUNCION'"+
			" and semana not like '999' group by departamento, distrito, semana order by CAST(coalesce(noti.semana, '0') AS integer), departamento, distrito),"+
			" cuartiles (departamento,distrito, cuartil_uno, cuartil_dos, cuartil_tres) as"+
			" (select departamento, distrito, CAST(coalesce(cuartil_uno, '0') AS integer), CAST(coalesce(cuartil_dos, '0') AS integer), CAST(coalesce(cuartil_tres, '0') AS integer) from cuartiles_por_distrito where tipo='DD')"+
			" select n.departamento || '-' ||n.distrito as distrito, n.semana, n.cantidad,"+
			" (CASE WHEN n.cantidad <= c.cuartil_uno THEN 'RB' "+
			"	WHEN n.cantidad <= c.cuartil_dos THEN 'RM'"+
			"	WHEN n.cantidad <= c.cuartil_tres THEN 'RA'"+
			"	ELSE 'E' END ) as riesgo"+
			" from notif n"+
			" left join cuartiles c"+
			" on (n.distrito = c.distrito and n.departamento = c.departamento)";
	public final static String RIESGOSPORANIO = "with notif (departamento, semana, cantidad) as"+
			" (select noti.departamento, CAST(coalesce(noti.semana, '0') AS integer) as semana, count(*) as cantidad from notificacion noti where anio='{0}' "+
			"	and semana not like '999' group by departamento, semana order by CAST(coalesce(noti.semana, '0') AS integer), departamento),"+
			" cuartiles (departamento, cuartil_uno, cuartil_dos, cuartil_tres) as"+
			" (select departamento, CAST(coalesce(cuartil_uno, '0') AS integer), CAST(coalesce(cuartil_dos, '0') AS integer), CAST(coalesce(cuartil_tres, '0') AS integer) from cuartiles_por_distrito where tipo='D')"+
			" select n.departamento, n.semana, n.cantidad,"+
			" (CASE WHEN n.cantidad <= c.cuartil_uno THEN 'RB' "+
			"	WHEN n.cantidad <= c.cuartil_dos THEN 'RM'"+
			"	WHEN n.cantidad <= c.cuartil_tres THEN 'RA'"+
			"	ELSE 'E' END ) as riesgo"+
			" from notif n"+
			" full join cuartiles c"+
			" on (n.departamento=c.departamento)";
	
	
	public final static String NOTIFFILTRADASMAP = "select count(*) as cantidad, departamento, semana, anio from notificacion where anio = '{0}' {1} group by anio, semana, departamento order by semana";

	public final static String NOTIFPORANIO = "select noti.departamento, CAST(coalesce(noti.semana, '0') AS integer) as semana, count(*) as cantidad from notificacion noti where anio='{0}' and semana not like '#VALUE!' group by departamento, semana order by CAST(coalesce(noti.semana, '0') AS integer), departamento";
}
