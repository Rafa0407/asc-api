package com.api.solcito.agropecuaria.empleados;

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
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;




@RestController
public class EmpleadoController {
	
	JSONObject o = new JSONObject();
	
	@Autowired
    private EmpleadosRepository empRepo; 
	

	@GetMapping("/emp") 
    public List<EmpleadoEntity> getAllEmployees (){
    	return empRepo.findAll();
    }
    
    @GetMapping("/emp/{idEmp}")
    public EmpleadoEntity getOneByEmpId (@PathVariable int idEmp) {
    	return empRepo.findOne(idEmp);
    } 
    
    @PostMapping("/emp")
    public EmpleadoEntity saveEmployee (@RequestBody EmpleadoEntity emp) {
    	return empRepo.save(emp);
    }
    
    @PutMapping("/emp")
    public ResponseEntity<?> updateEmployee (@RequestBody EmpleadoEntity emp) throws Exception{
    		
		try {
	    	// obteniendo el empleado 
	    	EmpleadoEntity updatedEmp = empRepo.findOne(emp.getIdEmpleado());  
        	// setiando valores al empleado por acutalizar 
        	updatedEmp.setidentificacion(emp.getIdentificacion());
        	updatedEmp.setNombre(emp.getNombre());
        	updatedEmp.setApellido1(emp.getApellido1());
        	updatedEmp.setApellido2(emp.getApellido2());	
        	// guardando el empleado con datos nuevos
        	empRepo.save(updatedEmp);	
			return new ResponseEntity<>(HttpStatus.CREATED); // CUANDO SOLO MUESTRA EL STATUS DE LA TRANSACCION 
		} catch (Exception e) {
			o.put ("error", "Empleado no existe");
			return new ResponseEntity<JSONObject>(o, HttpStatus.BAD_REQUEST);
		}
    }
    
    @DeleteMapping("/emp/{idEmp}")
    public boolean deleteEmployee (@PathVariable int idEmp) {
    	empRepo.delete(idEmp); 
    	return true;
    }
}
