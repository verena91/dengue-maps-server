/*
 * TICPY Framework
 * Copyright (C) 2012 Plan Director TICs
 *
----------------------------------------------------------------------------
 * Originally developed by SERPRO
 * Demoiselle Framework
 * Copyright (C) 2010 SERPRO
 *
----------------------------------------------------------------------------
 * This file is part of TICPY Framework.
 *
 * TICPY Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 *
----------------------------------------------------------------------------
 * Este archivo es parte del Framework TICPY.
 *
 * El TICPY Framework es software libre; Usted puede redistribuirlo y/o
 * modificarlo bajo los términos de la GNU Lesser General Public Licence versión 3
 * de la Free Software Foundation.
 *
 * Este programa es distribuido con la esperanza que sea de utilidad,
 * pero sin NINGUNA GARANTÍA; sin una garantía implícita de ADECUACION a cualquier
 * MERCADO o APLICACION EN PARTICULAR. vea la GNU General Public Licence
 * más detalles.
 *
 * Usted deberá haber recibido una copia de la GNU Lesser General Public Licence versión 3
 * "LICENCA.txt", junto con este programa; en caso que no, acceda a <http://www.gnu.org/licenses/>
 * o escriba a la Free Software Foundation (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */

package py.una.pol.denguemaps.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.QueryParam;

import org.ticpy.tekoporu.stereotype.PersistenceController;

import py.una.pol.denguemaps.domain.Notificacion;
import py.una.pol.denguemaps.util.JPACrud;

@PersistenceController
public class NotificacionDAO extends JPACrud<Notificacion, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public List<Notificacion> getNotificacionesPorAnio(String anio) {

		Query q = em.createQuery("select n from Notificacion n where n.anio='"
				+ anio + "'");
		try {
			List<Notificacion> listaevento = (List<Notificacion>) q
					.getResultList();
			return listaevento;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Notificacion> getNotificacionesFiltradas(String anio,
			String semana, String fechaNotificacion, String departamento,
			String distrito, String sexo, String edad, String resultado) {

		String wheres = "";

		if (anio != null && anio.compareTo("") != 0) {
			wheres = wheres + " n.anio='" + anio + "'";
		}
		if (semana != null && semana.compareTo("") != 0) {
			if (wheres.compareTo("") != 0) {
				wheres = wheres + " and " + " n.semana='" + semana + "'";
			} else {
				wheres = wheres + " n.semana='" + semana + "'";
			}
		}
		if (fechaNotificacion != null && fechaNotificacion.compareTo("") != 0) {
			if (wheres.compareTo("") != 0) {
				wheres = wheres + " and " + " n.fecha_notificacion='"
						+ fechaNotificacion + "'";
			} else {
				wheres = wheres + " n.fecha_notificacion='" + fechaNotificacion
						+ "'";
			}
		}
		if (departamento != null && departamento.compareTo("") != 0) {
			if (wheres.compareTo("") != 0) {
				wheres = wheres + " and " + " n.departamento='" + departamento
						+ "'";
			} else {
				wheres = wheres + " n.departamento='" + departamento + "'";
			}
		}
		if (distrito != null && distrito.compareTo("") != 0) {
			if (wheres.compareTo("") != 0) {
				wheres = wheres + " and " + " n.distrito='" + distrito + "'";
			} else {
				wheres = wheres + " n.distrito='" + distrito + "'";
			}
		}
		if (sexo != null && sexo.compareTo("") != 0) {
			if (wheres.compareTo("") != 0) {
				wheres = wheres + " and " + " n.sexo='" + sexo + "'";
			} else {
				wheres = wheres + " n.sexo='" + sexo + "'";
			}
		}

		if (edad != null && edad.compareTo("") != 0) {
			if (wheres.compareTo("") != 0) {
				wheres = wheres + " and " + " n.edad='" + edad + "'";
			} else {
				wheres = wheres + " n.edad='" + edad + "'";
			}
		}

		if (resultado != null && resultado.compareTo("") != 0) {
			if (wheres.compareTo("") != 0) {
				wheres = wheres + " and " + " n.clasificacon_clinica='"
						+ resultado + "'";
			} else {
				wheres = wheres + " n.clasificacon_clinica='" + resultado + "'";
			}
		}
		String query = "select n from Notificacion n";
		if (wheres.compareTo("") != 0) {
			query = query + " where " + wheres;
		} else {
			return null;
		}
		System.out.println("query " + query);
		Query q = em.createQuery(query);
		try {
			List<Notificacion> listaevento = (List<Notificacion>) q
					.getResultList();
			return listaevento;
		} catch (NoResultException e) {
			return null;
		}
	}

}
