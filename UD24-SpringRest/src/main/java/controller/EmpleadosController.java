package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.Empleados;
import service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadosController {

	@Autowired
	EmpleadoServiceImpl EmpleadoServideImpl;

	@GetMapping("/empleados")
	public List<Empleados> listarEmpleados(){
		return EmpleadoServideImpl.listarEmpleados();
	}
	
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleados> listarEmpleadoNombre(@PathVariable(name="trabajo") String trabajo) {
	    return EmpleadoServideImpl.listarEmpleadosTrabajo(trabajo);
	}
	
	@PostMapping("/empleados")
	public Empleados guardaEmpleado(@RequestBody Empleados Empleado) {
		switch (Empleado.getTrabajo()) {
		case "Analista":
			Empleado.setSalarioAnalista();
			break;
		case "Disenyador":
			Empleado.setSalarioDisenyador();
			break;
		case "Jefe":
			Empleado.setSalariojefe();
			break;


		default:
			Empleado.setSalarioProgramador();
			break;
		}
		
		return EmpleadoServideImpl.guardarEmpleados(Empleado);
	}
	
	@PutMapping("/empleados/{id},{trabajo}")
	public Empleados actualizarEmpleado(@PathVariable(name="id")int id,@RequestBody Empleados Empleado, @PathVariable(name="trabajo") String trabajo) {
		
		Empleados Empleado_seleccionado= new Empleados();
		Empleados Empleado_actualizado= new Empleados();
		
		Empleado_seleccionado= EmpleadoServideImpl.EmpleadosXID(id);
		
		Empleado_seleccionado.setNombre(Empleado.getNombre());
		Empleado_seleccionado.setTrabajo(Empleado.getTrabajo());
		switch (trabajo) {
		case "Analista":
			Empleado_seleccionado.setSalarioAnalista();
			break;
		case "Disenyador":
			Empleado_seleccionado.setSalarioDisenyador();
			break;
		case "Jefe":
			Empleado_seleccionado.setSalariojefe();
			break;


		default:
			Empleado_seleccionado.setSalarioProgramador();
			break;
		}
		
		
		Empleado_actualizado = EmpleadoServideImpl.actualizarEmpleados(Empleado_seleccionado);
		
		
		return Empleado_actualizado;
	}
	
	@DeleteMapping("/empleados/{id}")
	public void eleiminarEmpleado(@PathVariable(name="id")int id) {
		EmpleadoServideImpl.eliminarEmpleados(id);
	}

	
	
} 
