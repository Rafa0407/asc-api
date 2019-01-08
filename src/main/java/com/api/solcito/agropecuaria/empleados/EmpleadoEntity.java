package com.api.solcito.agropecuaria.empleados;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.api.solcito.agropecuaria.reporteDiario.ReporteDiarioEntity;
import com.api.solcito.agropecuaria.reporteSemanal.ReporteSemanalEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;  
	private String identificacion;
	private String nombre; 
	private String apellido1;
	private String apellido2; 
	
	
	@OneToMany(targetEntity = ReporteDiarioEntity.class , mappedBy = "empleado", orphanRemoval = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<ReporteDiarioEntity> repoDiario;
	
	@OneToMany(targetEntity = ReporteSemanalEntity.class , mappedBy = "empleado", orphanRemoval = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<ReporteSemanalEntity> repoSemanal;
	

	public EmpleadoEntity() {}

	public EmpleadoEntity(String identificacion, String nombre, String apellido1, String apellido2,
			String direccion, int telefono, String email, int idPuesto) {
		this.setidentificacion(identificacion);
		this.setNombre(nombre);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setidentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	

	public Set<ReporteDiarioEntity> getRepoDiario() {
		return repoDiario;
	}

	public void setRepoDiario(Set<ReporteDiarioEntity> repoDiario) {
		this.repoDiario = repoDiario;
	}

	public Set<ReporteSemanalEntity> getRepoSemanal() {
		return repoSemanal;
	}

	public void setRepoSemanal(Set<ReporteSemanalEntity> repoSemanal) {
		this.repoSemanal = repoSemanal;
	}
}
