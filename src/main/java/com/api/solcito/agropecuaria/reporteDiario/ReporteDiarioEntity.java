package com.api.solcito.agropecuaria.reporteDiario;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.api.solcito.agropecuaria.empleados.EmpleadoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "salarioDiario")
public class ReporteDiarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSalarioDiario;  
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate  fecha; 
	
	private Double montoDiario; 
	
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "idEmpleado")
	@Fetch(FetchMode.JOIN)
	private EmpleadoEntity empleado;

	public ReporteDiarioEntity () {}
	
	public ReporteDiarioEntity(LocalDate fecha, Double montoDiario, EmpleadoEntity empleado) {
		this.fecha = fecha;
		this.montoDiario = montoDiario;
		this.setEmpleado(empleado);
	}

	public int getIdSalarioDiario() {
		return idSalarioDiario;
	}
	public void setIdSalarioDiario(int idSalarioDiario) {
		this.idSalarioDiario = idSalarioDiario;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Double getMontoDiario() {
		return montoDiario;
	}
	public void setMontoDiario(Double montoDiario) {
		this.montoDiario = montoDiario;
	}

	
	public EmpleadoEntity getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoEntity empleado) {
		this.empleado = empleado;
	}



}
