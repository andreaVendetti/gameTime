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
	
	@Autowired
	private UtentiService serviceU;
	
	@Autowired
	private VideogiocoService serviceV;
	
	public List<TempoDiGioco> getTempoByUser(int id) {
		List<TempoDiGioco> time =  tRepository.findByUtente(id);
		for(int i = 0; i < time.size(); i++) {
			time.get(i).setUtente(serviceU.getUtente(time.get(i).getUtente().getId()));
			time.get(i).setVideogioco(serviceV.getVideogioco(time.get(i).getVideogioco().getId()));
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
