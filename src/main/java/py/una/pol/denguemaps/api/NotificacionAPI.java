package py.una.pol.denguemaps.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.una.pol.denguemaps.domain.Notificacion;

/**
 * Interfaz de servicios para notificaciones
 * 
 * @author desa2
 * 
 */
@Path("/notificacion")
public interface NotificacionAPI {

	/**
	 * Obtiene una lista de notificaciones paginada, ordenada y filtrada
	 * 
	 * @param page
	 *            Página
	 * @param limit
	 *            Cantidad por página
	 * @param sortField
	 *            Campo de ordenamiento
	 * @param sortOrder
	 *            Tipo de ordenamiento (ASCENDING, DESCENDING)
	 * @param notificacion
	 *            Notificacion con datos de filtrado
	 * @return
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotificaciones(@QueryParam("sEcho") int page,
			@QueryParam("sSearch_0") String anio,
			@QueryParam("sSearch_1") String semana,
			@QueryParam("sSearch_2") String fechaNotificacion,
			@QueryParam("sSearch_3") String departamento,
			@QueryParam("sSearch_4") String distrito,
			@QueryParam("sSearch_5") String sexo,
			@QueryParam("sSearch_6") String edad,
			@QueryParam("sSearch_7") String resultado,
			@QueryParam("iDisplayLength") int limit,
			@QueryParam("iSortCol_0") String sortField,
			@QueryParam("sSortDir_0") String sortOrder,
			@QueryParam("filtros") Notificacion notificacion);

	/**
	 * Retorna un json con datos de notificaciones
	 * 
	 * @param anio
	 *            anio de notificaciones
	 * @return
	 */
	@GET
	@Path("/{anio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonNotificacionesPorAnio(@PathParam("anio") String anio);

	@GET
	@Path("/riesgo/{anio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonRiesgosPorAnio(@PathParam("anio") String anio);

	@GET
	@Path("/riesgo/distrito/{anio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonRiesgosDistritoPorAnio(@PathParam("anio") String anio);

	@GET
	@Path("/riesgo/asuncion/{anio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonRiesgosAsuncionPorAnio(@PathParam("anio") String anio);

	@GET
	@Path("/filtro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotificacionesPorAnio(@QueryParam("anio") String anio);

	@GET
	@Path("/filtros")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotificacionesFiltradas(@QueryParam("anio") String anio,
			@QueryParam("semana") String semana,
			@QueryParam("fechaNotificacion") String fechaNotificacion,
			@QueryParam("departamento") String departamento,
			@QueryParam("distrito") String distrito,
			@QueryParam("sexo") String sexo, 
			@QueryParam("edad") String edad,
			@QueryParam("resultado") String resultado);

}
