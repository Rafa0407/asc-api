package com.api.solcito.agropecuaria.reporteDiario;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteDiarioRepository extends JpaRepository <ReporteDiarioEntity, Integer> {
	
	public List<ReporteDiarioEntity> findAllByOrderByFechaDesc();
	
	// retorna los salarios diarios de un empleado 
	@Query ("SELECT new com.api.solcito.agropecuaria.reporteDiario.ReporteDiarioDTO (rd.idSalarioDiario, rd.fecha, rd.montoDiario, emp.idEmpleado, emp.identificacion, emp.nombre, emp.apellido1, emp.apellido2)"
			+ "FROM ReporteDiarioEntity rd INNER JOIN rd.empleado emp "
			+ "WHERE emp.idEmpleado = :idEmp and rd.fecha between :fechaInicial and :fechaFinal ")
	List<ReporteDiarioDTO> getReporteDiarioByEmpleado(
			@Param("idEmp") int idEmp, 
			@Param("fechaInicial") LocalDate fechaInicial,
			@Param("fechaFinal") LocalDate fechaFinal
			);
	
	// retorna el monto total de salarios de un rango especifico de fechas y un empleado especifico
	@Query ("SELECT sum(rd.montoDiario)"
			+ "FROM ReporteDiarioEntity rd INNER JOIN rd.empleado emp "
			+ "WHERE emp.idEmpleado = :idEmp and rd.fecha between :fechaInicial and :fechaFinal")
	int getTotalSalariosDiarios (
			@Param("idEmp") int idEmp, 
			@Param("fechaInicial") LocalDate fechaInicial,
			@Param("fechaFinal") LocalDate fechaFinal
			);
}
