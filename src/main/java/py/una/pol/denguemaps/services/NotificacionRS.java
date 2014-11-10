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
	public Response getNotificaciones(int page, int limit, String sortField,
			String sortOrder, Notificacion notificacion) {
		System.out.println("+++++++++++++++++ Entro al servicio de notificaciones paginadas");
		List<Notificacion> finalList = new ArrayList<Notificacion>();
		PagedList<Notificacion> lista = new PagedList<Notificacion>();

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
		finalList = notificacionBC.findAll(sortField, asc, notificacion, pag);
		lista.setList(finalList);
		if (pag != null) {
			lista.setTotal(pag.getTotalResults());
		} else {
			lista.setTotal(finalList.size());
		}
		return Response.ok(finalList).build();
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
}
