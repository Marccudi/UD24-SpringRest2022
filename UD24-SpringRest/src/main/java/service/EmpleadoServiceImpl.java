package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IEmpleadoDAO;
import dto.Empleados;

public class EmpleadoServiceImpl implements IEmpleadoService{
	@Autowired
	IEmpleadoDAO iEmpleadosDAO;

	public List<Empleados> listarEmpleados() {

		return iEmpleadosDAO.findAll();
	}

	public Empleados EmpleadosXID(int id) {

		return iEmpleadosDAO.findById(id).get();
	}

	public Empleados guardarEmpleados(Empleados Empleados) {

		return iEmpleadosDAO.save(Empleados);
	}

	public Empleados actualizarEmpleados(Empleados Empleados) {

		return iEmpleadosDAO.save(Empleados);
	}

	public void eliminarEmpleados(int id) {

		iEmpleadosDAO.deleteById(id);

	}

	public List<Empleados> listarEmpleadosTrabajo(String trabajo) {

		return iEmpleadosDAO.findByTrabajo(trabajo);
	}

	





}
