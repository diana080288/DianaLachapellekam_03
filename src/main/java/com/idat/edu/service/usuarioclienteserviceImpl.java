package com.idat.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.model.usuariocliente;
import com.idat.edu.repository.usuarioclienterepository;

@Service
public class usuarioclienteserviceImpl implements usuarioclienteservice {
	
	@Autowired
	private usuarioclienterepository repository;

	@Override
	public void guardarusuariocliente(usuariocliente usuario) {
		// TODO Auto-generated method stub
		repository.save(usuario);

	}

	@Override
	public void actualizarusuariocliente(usuariocliente usuario) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(usuario);

	}

	@Override
	public void eliminarusuariocliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<usuariocliente> listarusuario() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public usuariocliente obtenerusuarioId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
