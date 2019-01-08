package com.api.solcito.agropecuaria.reporteDiario;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ReporteDiarioDTO {
	
	private int idSalarioDiario; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate  fecha; 
	
	private Double montoDiario; 
	private int idEmpleado;  
	private String identificacion;
	private String nombre; 
	private String apellido1;
	private String apellido2;
	
	public ReporteDiarioDTO () {} 
	public ReporteDiarioDTO(int idSalarioDiario , LocalDate fecha, Double montoDiario, int idEmpleado, String identificacion, String nombre,
			String apellido1, String apellido2) {
		this.idSalarioDiario = idSalarioDiario;
		this.fecha = fecha;
		this.montoDiario = montoDiario;
		this.idEmpleado = idEmpleado;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
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
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
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
	public int getidSalarioDiario() {
		return idSalarioDiario;
	}
	public void setidSalarioDiario(int idSalarioDiario) {
		this.idSalarioDiario = idSalarioDiario;
	}  
	
	
	
	
}
