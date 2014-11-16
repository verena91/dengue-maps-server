with distritos (distrito_descripcion) as 
( select b.distrito_descripcion from distrito b where b.departamento_descripcion = 'CONCEPCION' ), 
resultados (distrito) as 
( select n.distrito from notificacion n where n.departamento = 'CONCEPCION' group by n.distrito order by n.distrito ) 
select 
(CASE WHEN r.distrito IS NOT NULL THEN r.distrito ELSE '' END) as notiDistrito, (CASE WHEN t.distrito_descripcion IS NOT NULL THEN t.distrito_descripcion ELSE '' END) as distrito
from resultados r 
full join distritos t 
on (t.distrito_descripcion = r.distrito)

with notif (departamento, semana, cantidad) as
(select noti.departamento, CAST(coalesce(noti.semana, '0') AS integer) as semana, count(*) as cantidad from notificacion noti where anio='2009' 
	and semana not like '#VALUE!' group by departamento, semana order by CAST(coalesce(noti.semana, '0') AS integer), departamento),
cuartiles (departamento, cuartil_uno, cuartil_dos, cuartil_tres) as
(select departamento, CAST(coalesce(cuartil_uno, '0') AS integer), CAST(coalesce(cuartil_dos, '0') AS integer), CAST(coalesce(cuartil_tres, '0') AS integer) from cuartiles_por_distrito where tipo='D')
select n.departamento, n.semana, n.cantidad, c.departamento, c.cuartil_uno, c.cuartil_dos , c.cuartil_tres, 
(CASE WHEN n.cantidad <= c.cuartil_uno THEN 'RB' 
	WHEN n.cantidad <= c.cuartil_dos THEN 'RM'
	WHEN n.cantidad <= c.cuartil_tres THEN 'RA'
	ELSE 'E' END ) as riesgo
from notif n
full join cuartiles c
on (n.departamento=c.departamento)

update cuartiles_por_distrito set departamento = upper(departamento);


with notif (departamento,distrito, semana, cantidad) as
(select noti.departamento, noti.distrito, CAST(coalesce(noti.semana, '0') AS integer) as semana, count(*) as cantidad from notificacion noti where anio='{0}' 
	and semana not like '999' group by departamento, distrito, semana order by CAST(coalesce(noti.semana, '0') AS integer), departamento, distrito),
cuartiles (departamento,distrito, cuartil_uno, cuartil_dos, cuartil_tres) as
(select departamento, distrito, CAST(coalesce(cuartil_uno, '0') AS integer), CAST(coalesce(cuartil_dos, '0') AS integer), CAST(coalesce(cuartil_tres, '0') AS integer) from cuartiles_por_distrito where tipo='DD')
select n.departamento,n.distrito, n.semana, n.cantidad,
(CASE WHEN n.cantidad <= c.cuartil_uno THEN 'RB' 
	WHEN n.cantidad <= c.cuartil_dos THEN 'RM'
	WHEN n.cantidad <= c.cuartil_tres THEN 'RA'
	ELSE 'E' END ) as riesgo
from notif n
full join cuartiles c
on (n.distrito=c.distrito and n.departamento=c.departamento)