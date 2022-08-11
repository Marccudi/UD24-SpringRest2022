package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleados {
	enum Salario {
		Analista, Programador, Disenyador, Jefe
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	@Column
	private String trabajo;
	@Column
	private int salario;

	public Empleados() {
	}

	public Empleados(int id, String nombre, String trabajo) {
		this.id = id;
		this.nombre = nombre;
		this.trabajo = trabajo;
		for (Salario q : Salario.values()) {
			if (trabajo.equals(q+"")) {
				switch (q) {
				case Analista:
					this.salario = 73000;
					break;
				case Disenyador:
					this.salario = 24000;
					break;
				case Jefe:
					this.salario = 100000;
					break;
				default:
					this.trabajo ="Programador";
					this.salario = 28000;
					break;
				}
			}
		}
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public int getSalario() {
		return salario;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public void setSalarioAnalista() {
		this.salario = 73000;
	}

	public void setSalarioProgramador() {
		this.salario = 28000;
	}

	public void setSalarioDisenyador() {
		this.salario = 24000;
	}

	public void setSalariojefe() {
		this.salario = 100000;
	}

	@Override
	public String toString() {
		return "Empleados [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}

}
