package py.una.pol.denguemaps.configs;

import org.ticpy.tekoporu.configuration.Configuration;

@Configuration(resource = "query")
public class QueryConfig {
	private String root;

	private String permisoQuery;

	public String getPermisoQuery() {
		return permisoQuery;
	}

	public String getRoot() {
		return root;
	}
}
