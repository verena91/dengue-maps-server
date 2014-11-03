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
public class Notificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * If you are using Glassfish then remove the strategy attribute
	 */

	@Id
	//@GeneratedValue(strategy = SEQUENCE)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column
	private String semana;
	@Column
	private String anio;
	@Column
	private String institucion_notificacion;
	@Column
	private String fecha_notificacion;
	@Column
	private String edad;
	@Column
	private String sexo;
	@Column
	private String departamento;
	@Column
	private String distrito;
	@Column
	private String barrio;
	@Column
	private String ejes;
	@Column
	private String fecha_fiebre;
	@Column
	private String hospitalizado;
	@Column
	private String fecha_hospitalizacion;
	@Column
	private String ocupacion;
	@Column
	private String lugar_trabajo;
	@Column
	private String departamento_trabajo;
	@Column
	private String distrito_trabajo;
	@Column
	private String barrio_trabajo;
	@Column
	private String viajo;
	@Column
	private String fecha_viaje;
	@Column
	private String lugar_viaje;
	@Column
	private String departamento_viaje;
	@Column
	private String distrito_viaje;
	@Column
	private String exterior;
	@Column
	private String monte;
	@Column
	private String fecha_monte;
	@Column
	private String lugar_monte;
	@Column
	private String departamento_monte;
	@Column
	private String distrito_monte;
	@Column
	private String tuvo_cuadro_similar;
	@Column
	private String fecha_cuadro_similar;
	@Column
	private String caso_entorno;
	@Column
	private String resultado;
	@Column
	private String serotipo;
	@Column
	private String clasificacon_clinica;
	@Column
	private String clasificacion_final;
	@Column
	private String criterio;
	@Column
	private String fallecido;
	@Column
	private String fecha_defuncion;
	@Column
	private String fiebre;
	@Column
	private String cefalea;
	@Column
	private String mialgia;
	@Column
	private String altragia;
	@Column
	private String dolor_retro_ocular;
	@Column
	private String exantema;
	@Column
	private String nauseas;
	@Column
	private String shock;
	@Column
	private String dolor_adbominal;
	@Column
	private String frecuencia_dolor_abdominal;
	@Column
	private String inyeccion_conjuntival;
	@Column
	private String tos;
	@Column
	private String disnea;
	@Column
	private String taquipnea;
	@Column
	private String prurito;
	@Column
	private String ictericia;
	@Column
	private String vomitos;
	@Column
	private String edema_bipalpebral;
	@Column
	private String hepatomegalia;
	@Column
	private String esplenomegalia;
	@Column
	private String oligoanuaria;
	@Column
	private String sindrome_confusional;
	@Column
	private String sindrome_meningeo;
	@Column
	private String sindrome_hemorragico;
	@Column
	private String hemorragia_pulmonar;
	@Column
	private String petequias;
	@Column
	private String purpura;
	@Column
	private String epistaxis;
	@Column
	private String gingivorragia;
	@Column
	private String hemoptisis;
	@Column
	private String melena;
	@Column
	private String vomitos_negros;
	@Column
	private String ascitis;
	@Column
	private String derrame_pleural;
	@Column
	private String postracion;
	@Column
	private String hemorragias_diversas;
	@Column
	private String taquicardia;
	@Column
	private String otros;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getInstitucion_notificacion() {
		return institucion_notificacion;
	}

	public void setInstitucion_notificacion(String institucion_notificacion) {
		this.institucion_notificacion = institucion_notificacion;
	}

	public String getFecha_notificacion() {
		return fecha_notificacion;
	}

	public void setFecha_notificacion(String fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getEjes() {
		return ejes;
	}

	public void setEjes(String ejes) {
		this.ejes = ejes;
	}

	public String getFecha_fiebre() {
		return fecha_fiebre;
	}

	public void setFecha_fiebre(String fecha_fiebre) {
		this.fecha_fiebre = fecha_fiebre;
	}

	public String getHospitalizado() {
		return hospitalizado;
	}

	public void setHospitalizado(String hospitalizado) {
		this.hospitalizado = hospitalizado;
	}

	public String getFecha_hospitalizacion() {
		return fecha_hospitalizacion;
	}

	public void setFecha_hospitalizacion(String fecha_hospitalizacion) {
		this.fecha_hospitalizacion = fecha_hospitalizacion;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getLugar_trabajo() {
		return lugar_trabajo;
	}

	public void setLugar_trabajo(String lugar_trabajo) {
		this.lugar_trabajo = lugar_trabajo;
	}

	public String getDepartamento_trabajo() {
		return departamento_trabajo;
	}

	public void setDepartamento_trabajo(String departamento_trabajo) {
		this.departamento_trabajo = departamento_trabajo;
	}

	public String getDistrito_trabajo() {
		return distrito_trabajo;
	}

	public void setDistrito_trabajo(String distrito_trabajo) {
		this.distrito_trabajo = distrito_trabajo;
	}

	public String getBarrio_trabajo() {
		return barrio_trabajo;
	}

	public void setBarrio_trabajo(String barrio_trabajo) {
		this.barrio_trabajo = barrio_trabajo;
	}

	public String getViajo() {
		return viajo;
	}

	public void setViajo(String viajo) {
		this.viajo = viajo;
	}

	public String getFecha_viaje() {
		return fecha_viaje;
	}

	public void setFecha_viaje(String fecha_viaje) {
		this.fecha_viaje = fecha_viaje;
	}

	public String getLugar_viaje() {
		return lugar_viaje;
	}

	public void setLugar_viaje(String lugar_viaje) {
		this.lugar_viaje = lugar_viaje;
	}

	public String getDepartamento_viaje() {
		return departamento_viaje;
	}

	public void setDepartamento_viaje(String departamento_viaje) {
		this.departamento_viaje = departamento_viaje;
	}

	public String getDistrito_viaje() {
		return distrito_viaje;
	}

	public void setDistrito_viaje(String distrito_viaje) {
		this.distrito_viaje = distrito_viaje;
	}

	public String getExterior() {
		return exterior;
	}

	public void setExterior(String exterior) {
		this.exterior = exterior;
	}

	public String getMonte() {
		return monte;
	}

	public void setMonte(String monte) {
		this.monte = monte;
	}

	public String getFecha_monte() {
		return fecha_monte;
	}

	public void setFecha_monte(String fecha_monte) {
		this.fecha_monte = fecha_monte;
	}

	public String getLugar_monte() {
		return lugar_monte;
	}

	public void setLugar_monte(String lugar_monte) {
		this.lugar_monte = lugar_monte;
	}

	public String getDepartamento_monte() {
		return departamento_monte;
	}

	public void setDepartamento_monte(String departamento_monte) {
		this.departamento_monte = departamento_monte;
	}

	public String getDistrito_monte() {
		return distrito_monte;
	}

	public void setDistrito_monte(String distrito_monte) {
		this.distrito_monte = distrito_monte;
	}

	public String getTuvo_cuadro_similar() {
		return tuvo_cuadro_similar;
	}

	public void setTuvo_cuadro_similar(String tuvo_cuadro_similar) {
		this.tuvo_cuadro_similar = tuvo_cuadro_similar;
	}

	public String getFecha_cuadro_similar() {
		return fecha_cuadro_similar;
	}

	public void setFecha_cuadro_similar(String fecha_cuadro_similar) {
		this.fecha_cuadro_similar = fecha_cuadro_similar;
	}

	public String getCaso_entorno() {
		return caso_entorno;
	}

	public void setCaso_entorno(String caso_entorno) {
		this.caso_entorno = caso_entorno;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getSerotipo() {
		return serotipo;
	}

	public void setSerotipo(String serotipo) {
		this.serotipo = serotipo;
	}

	public String getClasificacon_clinica() {
		return clasificacon_clinica;
	}

	public void setClasificacon_clinica(String clasificacon_clinica) {
		this.clasificacon_clinica = clasificacon_clinica;
	}

	public String getClasificacion_final() {
		return clasificacion_final;
	}

	public void setClasificacion_final(String clasificacion_final) {
		this.clasificacion_final = clasificacion_final;
	}

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}

	public String getFallecido() {
		return fallecido;
	}

	public void setFallecido(String fallecido) {
		this.fallecido = fallecido;
	}

	public String getFecha_defuncion() {
		return fecha_defuncion;
	}

	public void setFecha_defuncion(String fecha_defuncion) {
		this.fecha_defuncion = fecha_defuncion;
	}

	public String getFiebre() {
		return fiebre;
	}

	public void setFiebre(String fiebre) {
		this.fiebre = fiebre;
	}

	public String getCefalea() {
		return cefalea;
	}

	public void setCefalea(String cefalea) {
		this.cefalea = cefalea;
	}

	public String getMialgia() {
		return mialgia;
	}

	public void setMialgia(String mialgia) {
		this.mialgia = mialgia;
	}

	public String getAltragia() {
		return altragia;
	}

	public void setAltragia(String altragia) {
		this.altragia = altragia;
	}

	public String getDolor_retro_ocular() {
		return dolor_retro_ocular;
	}

	public void setDolor_retro_ocular(String dolor_retro_ocular) {
		this.dolor_retro_ocular = dolor_retro_ocular;
	}

	public String getExantema() {
		return exantema;
	}

	public void setExantema(String exantema) {
		this.exantema = exantema;
	}

	public String getNauseas() {
		return nauseas;
	}

	public void setNauseas(String nauseas) {
		this.nauseas = nauseas;
	}

	public String getShock() {
		return shock;
	}

	public void setShock(String shock) {
		this.shock = shock;
	}

	public String getDolor_adbominal() {
		return dolor_adbominal;
	}

	public void setDolor_adbominal(String dolor_adbominal) {
		this.dolor_adbominal = dolor_adbominal;
	}

	public String getFrecuencia_dolor_abdominal() {
		return frecuencia_dolor_abdominal;
	}

	public void setFrecuencia_dolor_abdominal(String frecuencia_dolor_abdominal) {
		this.frecuencia_dolor_abdominal = frecuencia_dolor_abdominal;
	}

	public String getInyeccion_conjuntival() {
		return inyeccion_conjuntival;
	}

	public void setInyeccion_conjuntival(String inyeccion_conjuntival) {
		this.inyeccion_conjuntival = inyeccion_conjuntival;
	}

	public String getTos() {
		return tos;
	}

	public void setTos(String tos) {
		this.tos = tos;
	}

	public String getDisnea() {
		return disnea;
	}

	public void setDisnea(String disnea) {
		this.disnea = disnea;
	}

	public String getTaquipnea() {
		return taquipnea;
	}

	public void setTaquipnea(String taquipnea) {
		this.taquipnea = taquipnea;
	}

	public String getPrurito() {
		return prurito;
	}

	public void setPrurito(String prurito) {
		this.prurito = prurito;
	}

	public String getIctericia() {
		return ictericia;
	}

	public void setIctericia(String ictericia) {
		this.ictericia = ictericia;
	}

	public String getVomitos() {
		return vomitos;
	}

	public void setVomitos(String vomitos) {
		this.vomitos = vomitos;
	}

	public String getEdema_bipalpebral() {
		return edema_bipalpebral;
	}

	public void setEdema_bipalpebral(String edema_bipalpebral) {
		this.edema_bipalpebral = edema_bipalpebral;
	}

	public String getHepatomegalia() {
		return hepatomegalia;
	}

	public void setHepatomegalia(String hepatomegalia) {
		this.hepatomegalia = hepatomegalia;
	}

	public String getEsplenomegalia() {
		return esplenomegalia;
	}

	public void setEsplenomegalia(String esplenomegalia) {
		this.esplenomegalia = esplenomegalia;
	}

	public String getOligoanuaria() {
		return oligoanuaria;
	}

	public void setOligoanuaria(String oligoanuaria) {
		this.oligoanuaria = oligoanuaria;
	}

	public String getSindrome_confusional() {
		return sindrome_confusional;
	}

	public void setSindrome_confusional(String sindrome_confusional) {
		this.sindrome_confusional = sindrome_confusional;
	}

	public String getSindrome_meningeo() {
		return sindrome_meningeo;
	}

	public void setSindrome_meningeo(String sindrome_meningeo) {
		this.sindrome_meningeo = sindrome_meningeo;
	}

	public String getSindrome_hemorragico() {
		return sindrome_hemorragico;
	}

	public void setSindrome_hemorragico(String sindrome_hemorragico) {
		this.sindrome_hemorragico = sindrome_hemorragico;
	}

	public String getHemorragia_pulmonar() {
		return hemorragia_pulmonar;
	}

	public void setHemorragia_pulmonar(String hemorragia_pulmonar) {
		this.hemorragia_pulmonar = hemorragia_pulmonar;
	}

	public String getPetequias() {
		return petequias;
	}

	public void setPetequias(String petequias) {
		this.petequias = petequias;
	}

	public String getPurpura() {
		return purpura;
	}

	public void setPurpura(String purpura) {
		this.purpura = purpura;
	}

	public String getEpistaxis() {
		return epistaxis;
	}

	public void setEpistaxis(String epistaxis) {
		this.epistaxis = epistaxis;
	}

	public String getGingivorragia() {
		return gingivorragia;
	}

	public void setGingivorragia(String gingivorragia) {
		this.gingivorragia = gingivorragia;
	}

	public String getHemoptisis() {
		return hemoptisis;
	}

	public void setHemoptisis(String hemoptisis) {
		this.hemoptisis = hemoptisis;
	}

	public String getMelena() {
		return melena;
	}

	public void setMelena(String melena) {
		this.melena = melena;
	}

	public String getVomitos_negros() {
		return vomitos_negros;
	}

	public void setVomitos_negros(String vomitos_negros) {
		this.vomitos_negros = vomitos_negros;
	}

	public String getAscitis() {
		return ascitis;
	}

	public void setAscitis(String ascitis) {
		this.ascitis = ascitis;
	}

	public String getDerrame_pleural() {
		return derrame_pleural;
	}

	public void setDerrame_pleural(String derrame_pleural) {
		this.derrame_pleural = derrame_pleural;
	}

	public String getPostracion() {
		return postracion;
	}

	public void setPostracion(String postracion) {
		this.postracion = postracion;
	}

	public String getHemorragias_diversas() {
		return hemorragias_diversas;
	}

	public void setHemorragias_diversas(String hemorragias_diversas) {
		this.hemorragias_diversas = hemorragias_diversas;
	}

	public String getTaquicardia() {
		return taquicardia;
	}

	public void setTaquicardia(String taquicardia) {
		this.taquicardia = taquicardia;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public static Notificacion valueOf(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Notificacion bookmark = null;

		try {
			bookmark = mapper.readValue(json, Notificacion.class);
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
