package it.home.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.home.models.Videogioco;
import it.home.repositories.VideogiocoRepository;

@Service
public class VideogiocoService  {

	@Autowired
	private VideogiocoRepository repo;
	
	public Iterable<Videogioco> getAll(){
		return repo.findAll();
	} 
	
	public Videogioco getVideogioco(int id){
		return repo.findById(id).get();
	}
	
	public void save(Videogioco videogame) {
		repo.save(videogame);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
}
