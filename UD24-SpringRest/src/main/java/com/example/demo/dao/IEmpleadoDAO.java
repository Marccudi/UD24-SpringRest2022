package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Empleados;

public interface IEmpleadoDAO extends JpaRepository<Empleados, Integer> {
	public List<Empleados> findByNombre(String nombre);

	public List<Empleados> findByTrabajo(String trabajo);
}
