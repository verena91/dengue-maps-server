package py.una.pol.denguemaps.configs;

import org.ticpy.tekoporu.configuration.Configuration;

@Configuration(resource = "query")
public class QueryConfig {
	private String root;

	private String permisoQuery;
	
	private String notificacionesPorAnioQuery;
	
	private String riesgosPorAnio;
	
	private String riesgosDistritosPorAnio;

	public String getPermisoQuery() {
		return permisoQuery;
	}

	public String getRoot() {
		return root;
	}

	public String getNotificacionesPorAnioQuery() {
		return notificacionesPorAnioQuery;
	}

	public String getRiesgosPorAnio() {
		return riesgosPorAnio;
	}

	public String getRiesgosDistritosPorAnio() {
		return riesgosDistritosPorAnio;
	}
	
}
