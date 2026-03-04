package it.home.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.home.models.TempoDiGioco;
import it.home.repositories.TempoRepository;

@Service
public class TempoService {

	@Autowired
	private TempoRepository tRepository;
	
	public List<TempoDiGioco> getTempoByUser(int id) {
		List<TempoDiGioco> time =  tRepository.findByUtenteId(id);
		return time;
	}
	
	public TempoDiGioco getTempo(int id) {
		return tRepository.findById(id).get();
	}
	
	public Iterable<TempoDiGioco> getAll(){
		return tRepository.findAll();
	}
	
	public void delete(int id) {
		tRepository.deleteById(id);
	}
	
	public void save(TempoDiGioco tGioco) {
		tRepository.save(tGioco);
	}
}
