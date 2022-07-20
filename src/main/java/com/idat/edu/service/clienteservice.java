package com.idat.edu.service;

import java.util.List;

import com.idat.edu.model.cliente;



public interface clienteservice {
	
	void guardarcliente(cliente cliente);
	void actualizarcliente(cliente cliente);
	void eliminarcliente(Integer id);
	List<cliente> listarcliente();
	cliente obtenerclienteId(Integer id);	

}
