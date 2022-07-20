package com.idat.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.edu.model.hospital;

@Repository
public interface hospitalrepository  extends JpaRepository<hospital, Integer>{

}
