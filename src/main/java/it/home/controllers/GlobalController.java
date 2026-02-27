package it.home.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.home.models.Utente;
import it.home.models.Videogioco;
import it.home.services.UtentiService;
import it.home.services.VideogiocoService;

//Classe che serve per creare delle sessioni di oggetti 
@ControllerAdvice
public class GlobalController {

	@Autowired
	private UtentiService service;
	
	@Autowired
	private VideogiocoService serviceV;
	
	   @ModelAttribute("utente")
	    public Utente getUtente(@AuthenticationPrincipal UserDetails details) {
	        if(details != null) {
	            return service.findByEmail(details.getUsername()).orElse(null);
	        }
	        return null;
	    }
	   
	   @ModelAttribute("listaVideogiochi")
	   public Iterable<Videogioco> getVideogiochi(){
		   return serviceV.getAll();
	   }
}
