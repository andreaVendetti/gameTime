package it.home.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.home.models.Utente;
import it.home.repositories.UtenteRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	private UtenteRepository repository;
	
	public CustomUserDetailService(UtenteRepository repository) {
		this.repository = repository;
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utente u = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email non trovata"));
		// recupera l'utente tramite l'username
		//return User.withUsername(u.getUsername()).password(u.getPass()).roles("USER").build();
		
		return User.builder().username(email).password(u.getPass()).build();
	}

}
