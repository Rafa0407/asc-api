package com.api.solcito.agropecuaria.reporteDiario;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.solcito.agropecuaria.empleados.EmpleadoEntity;
import com.api.solcito.agropecuaria.empleados.EmpleadosRepository;

import net.minidev.json.JSONObject;

@RestController
public class ReporteDiarioController {

	@Autowired 
	ReporteDiarioRepository repDiarRepo; 

	@Autowired 
	EmpleadosRepository empRepo; 

	JSONObject o = new JSONObject(); 

	@GetMapping("/rep-diario")
	public List<ReporteDiarioEntity> index () {
		return repDiarRepo.findAllByOrderByFechaDesc();
	}

	@GetMapping("/rep-diario/{idEmpleado}")
	public ResponseEntity<?> salariosDiariosPorEmpleado(@PathVariable int idEmpleado, @RequestParam("fechaInicial") String fechaInicial,  @RequestParam("fechaFinal") String fechaFinal){
		
		EmpleadoEntity emp = empRepo.findOne(idEmpleado);
		if (emp != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			// transforming to localDate
			LocalDate fechaI = LocalDate.parse(fechaInicial, formatter); 
			LocalDate fechaF = LocalDate.parse(fechaFinal, formatter); 
			return new ResponseEntity<>(repDiarRepo.getReporteDiarioByEmpleado(idEmpleado, fechaI, fechaF), HttpStatus.OK);
		}
		else {
			o.put ("error", "Empleado no existe");
			return new ResponseEntity<JSONObject>(o, HttpStatus.BAD_REQUEST);
		}
	}
	
	// sumatoria de todos los salarios diarios de un rango de fecha 
	@GetMapping("/sum-rep-diar/{idEmpleado}")
	public int totalSalariosDiarios (@PathVariable int idEmpleado, @RequestParam("fechaInicial") String fechaInicial,  @RequestParam("fechaFinal") String fechaFinal) {
		LocalDate fechaI = LocalDate.parse(fechaInicial); 
		LocalDate fechaF = LocalDate.parse(fechaFinal); 
		return repDiarRepo.getTotalSalariosDiarios(idEmpleado, fechaI, fechaF);
	}

	@PostMapping("/rep-diario/{idEmp}")
	public ResponseEntity<?> saveReport(@PathVariable int idEmp, @RequestBody ReporteDiarioEntity repoDiario) {

		EmpleadoEntity emp = empRepo.findOne(idEmp);
		if (emp != null) {
			repoDiario.setEmpleado(emp);
			repDiarRepo.save(repoDiario);
			return new ResponseEntity<>(HttpStatus.CREATED); 
		}
		else {
			o.put ("error", "Empleado al que desea asignar reporte no existe");
			return new ResponseEntity<JSONObject>(o, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/rep-diario")
	public ResponseEntity<?> updateReport (@RequestBody ReporteDiarioEntity repoDiario){

		ReporteDiarioEntity repDiarioActualizar = repDiarRepo.findOne(repoDiario.getIdSalarioDiario()); 

		if (repDiarioActualizar != null) {
			repDiarioActualizar.setFecha(repoDiario.getFecha());
			repDiarioActualizar.setMontoDiario(repoDiario.getMontoDiario());
			repDiarRepo.save(repDiarioActualizar);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			o.put ("error", "El reporte no existe");
			return new ResponseEntity<JSONObject>(o, HttpStatus.BAD_REQUEST);
		}	
	}

	@DeleteMapping("/repDiario/{idReporteDiairo}")
	public boolean deleteReport (@PathVariable int idReporteDiairo){

		repDiarRepo.delete(idReporteDiairo);
		return true;
	}
}
