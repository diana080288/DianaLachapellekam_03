package com.idat.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.model.cliente;
import com.idat.edu.repository.clienterepository;

@Service
public class clienteserviceImpl implements clienteservice {
	
	@Autowired
	private clienterepository repository;

	@Override
	public void guardarcliente(cliente cliente) {
		// TODO Auto-generated method stub
		repository.save(cliente);

	}

	@Override
	public void actualizarcliente(cliente cliente) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(cliente);

	}

	@Override
	public void eliminarcliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<cliente> listarcliente() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public cliente obtenerclienteId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
