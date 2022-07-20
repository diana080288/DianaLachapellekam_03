package com.idat.edu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class cliente {
	
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private Integer celular;
	
	@ManyToMany(mappedBy = "cliente",cascade = 
			{CascadeType.PERSIST,CascadeType.MERGE})
	private List<hospital> hospital = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<usuariocliente> usuario = new ArrayList<>();
	
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCelular() {
		return celular;
	}
	public void setCelular(Integer celular) {
		this.celular = celular;
	}	
	
}
