package com.idat.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.edu.model.usuariocliente;

@Repository
public interface usuarioclienterepository extends JpaRepository<usuariocliente, Integer>{

	usuariocliente findByUsuario(String usuario);
}
