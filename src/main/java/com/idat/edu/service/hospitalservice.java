package com.idat.edu.service;

import java.util.List;

import com.idat.edu.dto.hospitaldtorequest;
import com.idat.edu.dto.hospitaldtoresponse;


public interface hospitalservice {

	void guardarhospital(hospitaldtorequest hospital);
	void actualizarhospital(hospitaldtorequest hospital);
	void eliminarhospital(Integer id);
	List<hospitaldtoresponse> listarhospital();
	hospitaldtoresponse obtenerhospitalId(Integer id);
}
