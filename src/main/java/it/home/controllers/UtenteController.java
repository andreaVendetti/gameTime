package it.home.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.home.models.Utente;
import it.home.services.UtentiService;

@Controller
public class UtenteController {
	// istanzia automaticamente la classe solo se la classe ha l'annotazione service
		/*
		 * Funziona così :
		 * 			1)spring avvia il container Spring/ApplicationContext(recipiente dove ci sono i bean ovvero determinati oggetti)
		 * 			2)scansiona le classi per trovare i bean
		 * 			3)istanzia prima le dipendenze ovvero "il @RestController dipende dalla @Service quindi istanzio la service e 
		 * 			  e la metto nel container"
		 * 			4)istanzia il controller e trova @Autowired quindi recupera dal cotainer la classe service e la inietta nel controller  
		 */
	@Autowired
	private UtentiService service;
	
	@GetMapping("/gametime/login")
	public String login(Model model) {
		model.addAttribute("utente", new Utente());
		return "login";
	}
	
	@GetMapping("/gametime/home")
	public String home(@ModelAttribute Utente utente, Model model) {
		Optional<Utente> verifica = service.findByEmail(utente.getEmail());
		if(verifica.isPresent()) {
			model.addAttribute("utente", verifica.get());			
		}
		return "home";
	}
	
	// url per accedere alla pagina web
	@GetMapping("/gametime/utenti")
	public String list(Model model) {
		model.addAttribute("utenti", service.getAll());
		//percorso della pagina html
		//return admin == true ? "utente/lista" : "utente/index";
		return "utente/lista";
	}
	
	// questo metodo serve per creare un utente vuoto e trasferirlo alla pagina di edit
	@GetMapping("/gametime/utenti/insert")
	public String edit(Model model) {
		model.addAttribute("utente", new Utente());
		return "utente/edit";
	}
	
	@PostMapping("/gametime/utenti/save")
	public ModelAndView edit(@ModelAttribute Utente utente) {
		service.saveUtente(utente);
		return new ModelAndView("redirect:/gametime/login");
	}
	
	@GetMapping("/gametime/utenti/update/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("utente", service.getUtente(id));
		return "utente/edit";		
	}
	
	@GetMapping("/gametime/utenti/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		model.addAttribute("utente",service.getUtente(id));
		return "utente/delete";		
	}
	
	@PostMapping("/gametime/utenti/delete")
	public ModelAndView delete(@ModelAttribute Utente utente) {
		service.deleteUtente(utente.getId());
		return new ModelAndView("redirect:/gametime/utenti");
	}
}
