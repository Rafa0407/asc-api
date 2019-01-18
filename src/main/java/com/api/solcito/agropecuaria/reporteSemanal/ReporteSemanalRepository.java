package com.api.solcito.agropecuaria.reporteSemanal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.api.solcito.agropecuaria.empleados.EmpleadoEntity;




public interface ReporteSemanalRepository extends JpaRepository <ReporteSemanalEntity, Integer>{
	
	public List<ReporteSemanalEntity> findAllByOrderByFechaReporteDesc();
	public ReporteSemanalEntity findByEmpleadoAndFechaReporteAndFechaInicialAndFechaFinal(@Param("empleado") EmpleadoEntity emp, @Param("fechaReporte") LocalDate fechaRepo, @Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal);
	public List<ReporteSemanalEntity> findAllByFechaReporte(@Param("fechaReporte") LocalDate fechaRepo);
}
