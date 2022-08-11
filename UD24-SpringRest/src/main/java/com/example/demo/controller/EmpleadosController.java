package com.example.demo.controller;

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

import com.example.demo.dto.Empleados;
import com.example.demo.service.EmpleadoServiceImpl;

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
			Empleado.setTrabajo("Programador");
			Empleado.setSalarioProgramador();
			break;
		}
		
		return EmpleadoServideImpl.guardarEmpleados(Empleado);
	}
	
	@PutMapping("/empleados/{id}")
	public Empleados actualizarEmpleado(@PathVariable(name="id")int id,@RequestBody Empleados Empleado) {
		
		Empleados Empleado_seleccionado= new Empleados();
		Empleados Empleado_actualizado= new Empleados();
		
		Empleado_seleccionado= EmpleadoServideImpl.EmpleadosXID(id);
		
		Empleado_seleccionado.setNombre(Empleado.getNombre());
		Empleado_seleccionado.setTrabajo(Empleado.getTrabajo());
		switch (Empleado_seleccionado.getTrabajo()) {
		case "Analista":
			Empleado_seleccionado.setSalarioAnalista();
			Empleado_seleccionado.setTrabajo("Analista");
			break;
		case "Disenyador":
			Empleado_seleccionado.setSalarioDisenyador();
			Empleado_seleccionado.setTrabajo("Disenyador");

			break;
		case "Jefe":
			Empleado_seleccionado.setSalariojefe();
			Empleado_seleccionado.setTrabajo("Jefe");
			break;
		default:
			Empleado_seleccionado.setSalarioProgramador();
			Empleado_seleccionado.setTrabajo("Programador");
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
