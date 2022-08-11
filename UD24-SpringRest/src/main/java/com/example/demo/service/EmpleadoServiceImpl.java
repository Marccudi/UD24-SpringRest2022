package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleados;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	@Autowired
	IEmpleadoDAO iEmpleadosDAO;

	@Override
	public List<Empleados> listarEmpleados() {

		return iEmpleadosDAO.findAll();
	}
	
	@Override
	public Empleados EmpleadosXID(int id) {

		return iEmpleadosDAO.findById(id).get();
	}

	@Override
	public Empleados guardarEmpleados(Empleados Empleados) {

		return iEmpleadosDAO.save(Empleados);
	}

	@Override
	public Empleados actualizarEmpleados(Empleados Empleados) {

		return iEmpleadosDAO.save(Empleados);
	}

	@Override
	public void eliminarEmpleados(int id) {

		iEmpleadosDAO.deleteById(id);

	}

	@Override
	public List<Empleados> listarEmpleadosTrabajo(String trabajo) {

		return iEmpleadosDAO.findByTrabajo(trabajo);
	}

	





}
