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

package py.una.pol.denguemaps.business;

import java.util.List;

import javax.inject.Inject;

import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.PaginatedDelegateCrud;

import py.una.pol.denguemaps.domain.Notificacion;
import py.una.pol.denguemaps.persistence.NotificacionDAO;

@BusinessController
public class NotificacionBC extends
		PaginatedDelegateCrud<Notificacion, Long, NotificacionDAO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private NotificacionDAO notificacionDAO;

	public List<Notificacion> findAll(String sortField, boolean sortOrder,
			Notificacion filtro, Pagination pag) {
		notificacionDAO.setPagination(pag);
		if (filtro != null) {
			if (sortField != null) {
				return notificacionDAO.findAll(sortField, sortOrder, filtro);
			} else {
				return notificacionDAO.findByExample(filtro);
			}
		} else {
			if (sortField != null) {
				return notificacionDAO.findAll(sortField, sortOrder);
			} else {
				return notificacionDAO.findAll();
			}
		}
	}

	public List<Notificacion> getNotificacionesPorAnio(String anio) {
		return notificacionDAO.getNotificacionesPorAnio(anio);
	}

	public List<Notificacion> getNotificacionesFiltradas(String anio,
			String semana, String fechaNotificacion, String departamento,
			String distrito, String sexo, String edad, String resultado) {
		return notificacionDAO.getNotificacionesFiltradas(anio, semana,
				fechaNotificacion, departamento, distrito, sexo, edad,
				resultado);
	}

}
