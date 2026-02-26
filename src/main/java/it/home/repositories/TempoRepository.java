package it.home.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.home.models.TempoDiGioco;

@Repository
public interface TempoRepository extends CrudRepository<TempoDiGioco, Integer> {
	
	public List<TempoDiGioco> findByUtenteId(int idUser);
	
}
