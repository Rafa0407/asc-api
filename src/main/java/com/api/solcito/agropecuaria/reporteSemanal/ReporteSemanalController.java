package com.api.solcito.agropecuaria.reporteSemanal;

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
public class ReporteSemanalController {

	@Autowired 
	ReporteSemanalRepository repSemanalRepo; 

	@Autowired 
	EmpleadosRepository empRepo;

	JSONObject o = new JSONObject(); 

	@GetMapping("/repo-semanal")
	public List<ReporteSemanalEntity> findAll (){
		return repSemanalRepo.findAllByOrderByFechaReporteDesc();
	}

	@GetMapping("/repos-semanales")
	public List<ReporteSemanalEntity> getByReportDate (@RequestParam("fechaReporte") String fechaRepo){ 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// transforming to localDate
		LocalDate fechaReporte = LocalDate.parse(fechaRepo, formatter); 
		
		return repSemanalRepo.findAllByFechaReporte(fechaReporte);
	}

	@PostMapping("/repo-semanal/{idEmpleado}")
	public ResponseEntity<?> saveReport (@PathVariable int idEmpleado, @RequestBody ReporteSemanalEntity repoSemanal){

		EmpleadoEntity empleado =  empRepo.findOne(idEmpleado); 

		if(empleado != null) {
			
			ReporteSemanalEntity repoExists= repSemanalRepo.findByEmpleadoAndFechaReporteAndFechaInicialAndFechaFinal(empleado, 
																													  repoSemanal.getFechaReporte(),
																													  repoSemanal.getFechaInicial(), 
																													  repoSemanal.getFechaFinal());
			if (repoExists == null) {
				repoSemanal.setEmpleado(empleado);
				repSemanalRepo.save(repoSemanal);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			else {
				o.put ("error", "El empleado ya posee un reporte en esa fecha o en ese rango de fechas");
				return new ResponseEntity<JSONObject>(o, HttpStatus.BAD_REQUEST);
			}
			
		}
		else {
			o.put ("error", "Empleado no existe");
			return new ResponseEntity<JSONObject>(o, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/repo-semanal")
	public ResponseEntity<?> updateReport(@RequestBody ReporteSemanalEntity repoSemanal){
		
		ReporteSemanalEntity reporteActualizar =  repSemanalRepo.findOne(repoSemanal.getIdReporte()); 

		if(reporteActualizar != null) {
			
			reporteActualizar.setSalarioNeto(repoSemanal.getSalarioNeto()); 
			reporteActualizar.setCcss(repoSemanal.getCcss()); 
			reporteActualizar.setHerramienta(repoSemanal.getHerramienta());
			reporteActualizar.setTransporte(repoSemanal.getTransporte());
			reporteActualizar.setRefrescos(repoSemanal.getRefrescos()); 
			reporteActualizar.setAdelantos(repoSemanal.getAdelantos());
			reporteActualizar.setSalarioTotal(repoSemanal.getSalarioTotal()); 
			reporteActualizar.setFechaInicial(repoSemanal.getFechaInicial());
			reporteActualizar.setFechaInicial(repoSemanal.getFechaFinal());
			
			repSemanalRepo.save(reporteActualizar);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			o.put ("error", "Reporte no existe");
			return new ResponseEntity<JSONObject>(o, HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/repo-semanal/{idRepoSemanal}")
	public boolean deleteReport(@PathVariable int idRepoSemanal){
		repSemanalRepo.delete(idRepoSemanal);
		return true; 
	}


}
