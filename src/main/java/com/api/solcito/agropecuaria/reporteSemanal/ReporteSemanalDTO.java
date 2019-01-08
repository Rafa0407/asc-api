package com.api.solcito.agropecuaria.reporteSemanal;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReporteSemanalDTO {

	private int idReporte; 

	private Double salarioNeto; 
	private Double ccss;
	private Double herramienta;
	private Double transporte; 
	private Double refrescos; 
	private Double adelantos; 
	private Double salarioTotal;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate fechaReporte;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate fechaInicial; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate fechaFinal;

	private String nombre; 
	private String apellido1;
	private String apellido2;
	public ReporteSemanalDTO(int idReporte, Double salarioNeto, Double ccss, Double herramienta, Double transporte,
			Double refrescos, Double adelantos, Double salarioTotal, LocalDate fechaReporte, LocalDate fechaInicial,
			LocalDate fechaFinal, String nombre, String apellido1, String apellido2) {
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
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
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

}
