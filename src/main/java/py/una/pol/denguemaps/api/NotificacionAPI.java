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
	public Response getNotificaciones(@QueryParam("draw") int page,
			@QueryParam("length") int limit,
			@QueryParam("order[0][column]") String sortField,
			@QueryParam("order[0][dir]") String sortOrder,
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


}
