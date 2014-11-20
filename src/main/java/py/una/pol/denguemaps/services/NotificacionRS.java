package py.una.pol.denguemaps.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.ticpy.tekoporu.internal.implementation.PaginationImpl;
import org.ticpy.tekoporu.pagination.Pagination;

import py.una.pol.denguemaps.api.NotificacionAPI;
import py.una.pol.denguemaps.business.NotificacionBC;
import py.una.pol.denguemaps.configs.QueryConfig;
import py.una.pol.denguemaps.domain.Notificacion;
import py.una.pol.denguemaps.util.NativeQueryFileManager;
import py.una.pol.denguemaps.util.PagedList;

/**
 * Servicio REST para las operaciones sobre Bookmarks, implementa la interfaz
 * BookmarkAPI
 * 
 * @author desa2
 * 
 */
public class NotificacionRS implements NotificacionAPI {

	/** Inyecciones de dependencias **/

	@Inject
	private NotificacionBC notificacionBC;

	@Inject
	private Logger log;

	/** Métodos de la API **/

	@Override
	public Response getNotificaciones(int page, String anio, String semana, String fechaNotificacion,
			String departamento, String distrito, String sexo, String edad,
			String resultado, int limit, String sortField,
			String sortOrder, Notificacion notificacion) {
		System.out.println("+++++++++++++++++ Entro al servicio de notificaciones paginadas");
		List<Notificacion> finalList = new ArrayList<Notificacion>();
		PagedList<Notificacion> lista = new PagedList<Notificacion>();
		//PagedList<String[]> lista = new PagedList<String[]>();
		
		System.out.println("+++++++++++++++++ sortField " + sortField);
		System.out.println("+++++++++++++++++ sortOrder " + sortOrder);
		
		if (sortField.compareTo("0") == 0) {
			sortField = "anio";
		} else if (sortField.compareTo("1") == 0) {
			sortField = "semana";
		} else if (sortField.compareTo("2") == 0) {
			sortField = "fecha_notificacion";
		} else if (sortField.compareTo("3") == 0) {
			sortField = "departamento";
		} else if (sortField.compareTo("4") == 0) {
			sortField = "distrito";
		} else if (sortField.compareTo("5") == 0) {
			sortField = "sexo";
		} else if (sortField.compareTo("6") == 0) {
			sortField = "edad";
		} else if (sortField.compareTo("7") == 0) {
			sortField = "clasificacion_clinica";
		} else {
			sortField = "id";
		}
		
		System.out.println("+++" + anio + "+++");
		System.out.println("+++" + semana + "+++");
		System.out.println("+++" + departamento + "+++");
		System.out.println("+++" + distrito + "+++");
		System.out.println("+++" + resultado + "+++");
		System.out.println("+++" + sexo + "+++");
		System.out.println("+++" + edad + "+++");
		
		Notificacion filtro = new Notificacion();
		
		boolean tieneFiltro = false;
		
		filtro.setId(null);
		
		if (anio != null && anio.compareTo("")!=0) {
			filtro.setAnio(anio);
			tieneFiltro = true;
		}
		if (semana != null && semana.compareTo("")!=0) {
			filtro.setSemana(semana);
			tieneFiltro = true;
		}
		if (fechaNotificacion != null && fechaNotificacion.compareTo("")!=0) {
			filtro.setFecha_notificacion(fechaNotificacion);
			tieneFiltro = true;
		}
		if (departamento != null && departamento.compareTo("")!=0) {
			filtro.setDepartamento(departamento);
			tieneFiltro = true;
		}
		if (distrito != null && distrito.compareTo("")!=0) {
			filtro.setDistrito(distrito);
			tieneFiltro = true;
		}
		if (sexo != null && sexo.compareTo("")!=0) {
			filtro.setSexo(sexo);
			tieneFiltro = true;
		}
		if (edad != null && edad.compareTo("")!=0) {
			filtro.setEdad(edad);
			tieneFiltro = true;
		}
		if (resultado!= null && resultado.compareTo("")!=0) {
			filtro.setClasificacon_clinica(resultado);
			tieneFiltro = true;
		}

		
		Pagination pag = null;

		// paginar o no
		if (page != 0) {
			pag = new PaginationImpl();
			pag.setPageSize(limit);
			pag.setCurrentPage(page - 1);
		}

		// setear order by
		boolean asc = true;
		if (sortField != null) {
			if (sortOrder.compareTo("asc") != 0) {
				asc = false;
			}
		}
		
		if (tieneFiltro){
			finalList = notificacionBC.findAll(sortField, asc, /*notificacion*/filtro, pag);	
		} else {
			finalList = notificacionBC.findAll(sortField, asc, null, pag);
		}
		
		
		List<String[]> list = new ArrayList<String[]>();
		for (Notificacion not : finalList) {
			String[] row = new String[8];
			//row[0] = not.getId() + "";
			row[0] = not.getAnio();
			row[1] = not.getSemana();
			row[2] = not.getFecha_notificacion();
			row[3] = not.getDepartamento();
			row[4] = not.getDistrito();
			row[5] = not.getSexo();
			row[6] = not.getEdad();
			row[7] = not.getClasificacon_clinica();
			list.add(row);
		}

		lista.setData(finalList);
		//lista.setData(list);
		
		if (pag != null) {
			lista.setRecordsTotal(pag.getTotalResults());
			lista.setDraw(page);
			lista.setRecordsFiltered(pag.getTotalResults());
		} else {
			lista.setRecordsTotal(finalList.size());
			lista.setDraw(page);
			lista.setRecordsFiltered(finalList.size());
		}
		return Response.ok(lista).build();
	}

	@Inject
	NativeQueryFileManager n;

	@Inject
	QueryConfig queryConfig;

	@Override
	public Response getJsonNotificacionesPorAnio(String anio) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = n.executeNativeQueryFromFileParameters(queryConfig.getRoot()
					+ queryConfig.getNotificacionesPorAnioQuery(), anio);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return Response.ok(list).build();
	}
	
	public Response getJsonRiesgosPorAnio(String anio){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = n.executeNativeQueryFromFileParameters(queryConfig.getRoot()
					+ queryConfig.getRiesgosPorAnio(), anio);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return Response.ok(list).build();
	}

	@Override
	public Response getJsonRiesgosDistritoPorAnio(String anio) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = n.executeNativeQueryFromFileParameters(queryConfig.getRoot()
					+ queryConfig.getRiesgosDistritosPorAnio(), anio);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return Response.ok(list).build();
	}

	@Override
	public Response getJsonRiesgosAsuncionPorAnio(String anio) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = n.executeNativeQueryFromFileParameters(queryConfig.getRoot()
					+ queryConfig.getRiesgosAsuncionPorAnio(), anio);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return Response.ok(list).build();
	}

	@Override
	public Response getNotificacionesPorAnio(String anio) {
		System.out.println("+++++++ servicios de notificaciones por anio");
		List<Notificacion> list = notificacionBC.getNotificacionesPorAnio(anio);

		return Response.ok(list).build();
	}

	@Override
	public Response getNotificacionesFiltradas(String anio, String semana,
			String fechaNotificacion, String departamento, String distrito,
			String sexo, String edad, String resultado) {
		System.out.println("+++++++ servicios de notificaciones filtradas");
		List<Notificacion> list = notificacionBC.getNotificacionesFiltradas(
				anio, semana, fechaNotificacion, departamento, distrito, sexo,
				edad, resultado);

		return Response.ok(list).build();
	}

	@Override
	public Response getJsonNotificacionesPorFiltros(String anio, String sexo,
			String resultado) {
		String query = "select count(*), semana, anio, from notificacion where anio = '"+anio+"'";
		if(sexo!=null){
			query = query + "and sexo = "+sexo;
		}
		if(resultado!=null){
			
		}
			
		query = query +  "group by semana";
		return null;
	}
	

}
