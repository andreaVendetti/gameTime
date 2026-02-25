package it.home.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.home.models.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Integer> {

	Optional<Utente> findByEmail(String email);
	
}
