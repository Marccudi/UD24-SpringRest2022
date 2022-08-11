package service;

import java.util.List;

import dto.Empleados;

public interface IEmpleadoService {
	
	//Metodos del CRUD
		public List<Empleados> listarEmpleados(); //Listar All 
		
		public Empleados guardarEmpleados(Empleados Empleado);	//Guarda un Empleado CREATE
		
		public Empleados EmpleadosXID(int id); //Leer datos de un Empleado READ
		
		
		public Empleados actualizarEmpleados(Empleados Empleado); //Actualiza datos del Empleado UPDATE
		
		public void eliminarEmpleados(int id);// Elimina el Empleado DELETE

		public List<Empleados> listarEmpleadosTrabajo(String trabajo); //Muestra nombres según el trabajo indicado
}
