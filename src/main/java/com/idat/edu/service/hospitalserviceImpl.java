package com.idat.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.dto.hospitaldtorequest;
import com.idat.edu.dto.hospitaldtoresponse;
import com.idat.edu.model.hospital;
import com.idat.edu.repository.hospitalrepository;

@Service
public class hospitalserviceImpl implements hospitalservice {
	
	@Autowired
	private hospitalrepository repository;
	

	@Override
	public void guardarhospital(hospitaldtorequest hospital) {
		// TODO Auto-generated method stub
		hospital a = new hospital(); 
		a.setNombre(hospital.getNombre());
		a.setDescripcion(a.getDescripcion());
		a.setDistrito(hospital.getDistritohospital());
		repository.save(a);

	}

	@Override
	public void actualizarhospital(hospitaldtorequest hospital) {
		// TODO Auto-generated method stub
		hospital a = new hospital();
		a.setIdHospital(hospital.getId());
		a.setNombre(hospital.getNombre());
		a.setDescripcion(a.getDescripcion());
		a.setDistrito(hospital.getDistritohospital());
		repository.saveAndFlush(a);
		
	}

	@Override
	public void eliminarhospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		

	}

	@Override
	public List<hospitaldtoresponse> listarhospital() {
		// TODO Auto-generated method stub
		List<hospitaldtoresponse> listar = new ArrayList<>();
		hospitaldtoresponse dto = null;
		List<hospital> a = repository.findAll();
		for(hospital hospital : a) {
			listar.add(dto);
		}
		
		return null;
	}

	@Override
	public hospitaldtoresponse obtenerhospitalId(Integer id) {
		// TODO Auto-generated method stub
		hospital hospital = repository.findById(id).orElse(null);
		hospitaldtoresponse dto = new hospitaldtoresponse();
		dto.setId(hospital.getIdHospital());
		dto.setNombre(hospital.getNombre());
		dto.setDescripcionhospital(hospital.getDescripcion());
		dto.setDistritohospital(hospital.getDistrito());
		
		
		return null;
	}

}
