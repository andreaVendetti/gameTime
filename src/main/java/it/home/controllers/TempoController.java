package it.home.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.home.models.TempoDiGioco;
import it.home.models.Utente;
import it.home.services.TempoService;
import it.home.services.UtentiService;

@Controller
public class TempoController {

	@Autowired
	private TempoService service;
	
	@Autowired
	private UtentiService serviceU;
	
	@GetMapping("/gametime/tempi")
	public String list(@AuthenticationPrincipal UserDetails details, Model model ) {
		Optional<Utente> u = serviceU.findByEmail(details.getUsername());
		if(u.isPresent() && u.get().getAdmin() == 2) {
			List<TempoDiGioco> list = service.getTempoByUser(u.get().getId());
			model.addAttribute("lista", list);
		} else if(u.isPresent() && u.get().getAdmin() != 2) {
			Iterable<TempoDiGioco> ite = service.getAll();
			model.addAttribute("lista", ite);
		}
		return "tempo/lista";
	}
	
}
