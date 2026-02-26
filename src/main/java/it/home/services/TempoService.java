package it.home.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.home.models.TempoDiGioco;
import it.home.repositories.TempoRepository;

public class TempoService {

	@Autowired
	private TempoRepository tRepository;
	
	@Autowired
	private UtentiService serviceU;
	
	@Autowired
	private VideogiocoService serviceV;
	
	public Optional<TempoDiGioco> getTempo(int id) {
		Optional<TempoDiGioco> time =  tRepository.findById(id);
		if(time.isPresent()) {
			time.get().setUtente(serviceU.getUtente(time.get().getUtente().getId()));
			time.get().setVideogioco(serviceV.getVideogioco(time.get().getVideogioco().getId()));
		}
		return time;
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
