package com.api.solcito.agropecuaria.reporteSemanal;

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

@Entity()
@Table(name= "reporteSalarial")
public class ReporteSemanalEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReporte; 
	
	private Double salarioNeto; 
	private Double ccss;
	private Double herramienta;
	private Double transporte; 
	private Double refrescos; 
	private Double adelantos; 
	private Double salarioTotal;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaReporte;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaInicial; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaFinal;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "idEmpleado")
	@Fetch(FetchMode.JOIN)
	private EmpleadoEntity empleado;

	public ReporteSemanalEntity() {}
	public ReporteSemanalEntity(int idReporte, Double salarioNeto, Double ccss, Double herramienta, Double transporte,
			Double refrescos, Double adelantos, Double salarioTotal, LocalDate fechaReporte, LocalDate fechaInicial,
			LocalDate fechaFinal, EmpleadoEntity empleado) {
		this.idReporte = idReporte;
		this.salarioNeto = salarioNeto;
		this.ccss = ccss;
		this.herramienta = herramienta;
		this.transporte = transporte;
		this.refrescos = refrescos;
		this.adelantos = adelantos;
		this.salarioTotal = salarioTotal;
		this.fechaReporte = fechaReporte;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.setEmpleado(empleado);
	}

	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public Double getSalarioNeto() {
		return salarioNeto;
	}

	public void setSalarioNeto(Double salarioNeto) {
		this.salarioNeto = salarioNeto;
	}

	public Double getCcss() {
		return ccss;
	}

	public void setCcss(Double ccss) {
		this.ccss = ccss;
	}

	public Double getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Double herramienta) {
		this.herramienta = herramienta;
	}

	public Double getTransporte() {
		return transporte;
	}

	public void setTransporte(Double transporte) {
		this.transporte = transporte;
	}

	public Double getRefrescos() {
		return refrescos;
	}

	public void setRefrescos(Double refrescos) {
		this.refrescos = refrescos;
	}

	public Double getAdelantos() {
		return adelantos;
	}

	public void setAdelantos(Double adelantos) {
		this.adelantos = adelantos;
	}

	public Double getSalarioTotal() {
		return salarioTotal;
	}

	public void setSalarioTotal(Double salarioTotal) {
		this.salarioTotal = salarioTotal;
	}

	public LocalDate getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(LocalDate fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public LocalDate getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public EmpleadoEntity getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoEntity empleado) {
		this.empleado = empleado;
	}
	
	
	
	

}
