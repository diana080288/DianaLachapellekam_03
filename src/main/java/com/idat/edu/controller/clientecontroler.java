package com.idat.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.edu.model.cliente;
import com.idat.edu.service.clienteservice;

@Controller
@RequestMapping(path = " /cliente/v1")
public class clientecontroler {
	
	@Autowired
	private clienteservice service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<cliente>> listar(){
		return new ResponseEntity<List<cliente>>(service.listarcliente(), HttpStatus.OK);
	}

}
