package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Login;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {

			private LoginRepository loginrepo;
			
			
			public LoginService(LoginRepository loginrep) {
				 this.loginrepo = loginrep;
			}
			
			
			 public Login autentificacion(String username, String password) {
				 	
					return this.loginrepo.autentificacion(username, password);
			}
}
