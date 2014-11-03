/*
 * CEAMSO-USAID
 * Copyright (C) 2014 Governance and Democracy Program
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.private String See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,private String see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MAprivate String 02110-1301, USA.
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

package py.una.pol.denguemaps.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.io.StringWriter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Barrio implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * If you are using Glassfish then remove the strategy attribute
	 */

	@Id
	// @GeneratedValue(strategy = SEQUENCE)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column
	private String departamento_codigo;

	@Column
	private String departamento_descripcion;

	@Column
	private String distrito_codigo;

	@Column
	private String distrito_descripcion;

	@Column
	private String codigo;

	@Column
	private String area;

	@Column
	private String barrio_codigo;

	@Column
	private String barrio_descripcion;

	@Column
	private String cantidad_viv;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartamento_codigo() {
		return departamento_codigo;
	}

	public void setDepartamento_codigo(String departamento_codigo) {
		this.departamento_codigo = departamento_codigo;
	}

	public String getDepartamento_descripcion() {
		return departamento_descripcion;
	}

	public void setDepartamento_descripcion(String departamento_descripcion) {
		this.departamento_descripcion = departamento_descripcion;
	}

	public String getDistrito_codigo() {
		return distrito_codigo;
	}

	public void setDistrito_codigo(String distrito_codigo) {
		this.distrito_codigo = distrito_codigo;
	}

	public String getDistrito_descripcion() {
		return distrito_descripcion;
	}

	public void setDistrito_descripcion(String distrito_descripcion) {
		this.distrito_descripcion = distrito_descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBarrio_codigo() {
		return barrio_codigo;
	}

	public void setBarrio_codigo(String barrio_codigo) {
		this.barrio_codigo = barrio_codigo;
	}

	public String getBarrio_descripcion() {
		return barrio_descripcion;
	}

	public void setBarrio_descripcion(String barrio_descripcion) {
		this.barrio_descripcion = barrio_descripcion;
	}

	public String getCantidad_viv() {
		return cantidad_viv;
	}

	public void setCantidad_viv(String cantidad_viv) {
		this.cantidad_viv = cantidad_viv;
	}

	public static Barrio valueOf(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Barrio bookmark = null;

		try {
			bookmark = mapper.readValue(json, Barrio.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookmark;
	}

	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter json = new StringWriter();

		try {
			mapper.writeValue(json, this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json.toString();
	}

}
