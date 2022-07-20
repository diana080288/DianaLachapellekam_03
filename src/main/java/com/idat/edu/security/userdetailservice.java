package com.idat.edu.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.edu.model.usuariocliente;
import com.idat.edu.repository.usuarioclienterepository;

@Service
public class userdetailservice implements UserDetailsService {
	
	@Autowired
	private usuarioclienterepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		usuariocliente usuario = repository.findByUsuario(username);
		
		if(usuario != null) {
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority granted = new SimpleGrantedAuthority("Diana");
			listGranted.add(granted);
			
			return new User(usuario.getUsuario(),usuario.getPassword(),listGranted);
		}else
			
			throw new UsernameNotFoundException("usuario no existe"+ username);
			
	}

}
