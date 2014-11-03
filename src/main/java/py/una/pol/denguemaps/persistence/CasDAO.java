package py.una.pol.denguemaps.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import py.una.pol.denguemaps.configs.QueryConfig;
import py.una.pol.denguemaps.util.NativeQueryFileManager;

public class CasDAO {

	@Inject
	NativeQueryFileManager n;
	
	@Inject
	QueryConfig queryConfig;
	
	public List<Map<String, Object>> getPermisos(String usuario){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = n.executeNativeQueryFromFileParameters(queryConfig.getRoot()
					+ queryConfig.getPermisoQuery(), usuario);
			return list;
		} catch (Exception e) {
			return null;
		}
		
	}
}
