package it.home.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.home.models.TempoDiGioco;
import it.home.models.Utente;
import it.home.models.Videogioco;
import it.home.services.TempoService;
import it.home.services.UtentiService;
import it.home.services.VideogiocoService;

@Controller
public class TempoController {

	@Autowired
	private TempoService service;

	@Autowired
	private UtentiService serviceU;
	
	@Autowired 
	private VideogiocoService serviceV;
	
	@GetMapping("/gametime/tempi")
	public String list(@AuthenticationPrincipal UserDetails details, Model model ) {
		if(details == null) {
			return "redirect:/login";
		}		
		Utente u = serviceU.findByEmail(details.getUsername()).get();
		System.out.println(u.getAdmin());
		if(u.getAdmin() == 2) {
			model.addAttribute("lista", service.getTempoByUser(u.getId()));
		} else {
			model.addAttribute("lista", service.getAll());
		}
		return "tempo/lista";
	}
	
	@GetMapping("/gametime/tempi/insert")
	public String insert(Model model) {
		model.addAttribute("tempo", new TempoDiGioco());
		return "tempo/edit";
	}
	
	@PostMapping("/gametime/tempi/save")
	public String save(@ModelAttribute TempoDiGioco t) {
		
		Videogioco v = serviceV.getVideogioco(t.getVideogioco().getId());
		t.setVideogioco(v);
		
		service.save(t);
		return "redirect:/gametime/tempi";
	}
	
}
