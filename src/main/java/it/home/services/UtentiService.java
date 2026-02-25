package it.home.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.home.models.Utente;
import it.home.repositories.UtenteRepository;

@Service
public class UtentiService {

	@Autowired
	private UtenteRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Iterable<Utente> getAll(){
		return repo.findAll();
	}
	
	public Utente getUtente(int id) {
		Optional<Utente> prova = repo.findById(id);
		return  prova.get();
	}
	
	public void deleteUtente(int id) {
		repo.deleteById(id);
	}
	
	public void saveUtente(Utente utente) {
		utente.setPass(encoder.encode(utente.getPass()));
		if(utente.getEmail().matches("^[a-zA-Z0-9._%+-]+@admin(master?)\\.com$")) {
			utente.setAdmin(utente.getEmail().contains("master")  ? 0 : 1);
		} else {
			utente.setAdmin(2);
		}
		repo.save(utente);
	}
	
	public Optional<Utente> findByEmail(String email) {
		
		return repo.findByEmail(email);
	}
}
