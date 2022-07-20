package com.idat.edu.service;

import java.util.List;

import com.idat.edu.model.usuariocliente;

public interface usuarioclienteservice {
	
	void guardarusuariocliente(usuariocliente usuario);
	void actualizarusuariocliente(usuariocliente usuario);
	void eliminarusuariocliente(Integer id);
	List<usuariocliente> listarusuario();
	usuariocliente obtenerusuarioId(Integer id);

}
