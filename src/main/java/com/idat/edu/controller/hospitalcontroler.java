package com.idat.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.edu.dto.hospitaldtoresponse;
import com.idat.edu.service.hospitalservice;

@Controller
@RequestMapping(path = " /hospital/v1")
public class hospitalcontroler {
	
	@Autowired
	private hospitalservice service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<hospitaldtoresponse>> listar(){
		return new ResponseEntity<List<hospitaldtoresponse>>(service.listarhospital(),HttpStatus.OK);
	}

}
