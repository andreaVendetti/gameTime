package it.home.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.home.models.TempoDiGioco;
import it.home.models.Utente;
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
	public String edit(@ModelAttribute TempoDiGioco t, @AuthenticationPrincipal UserDetails det, Model model) {
		t.setVideogioco(serviceV.getVideogioco(t.getVideogioco().getId()));
		t.setUtente(serviceU.findByEmail(det.getUsername()).get());
		if(!t.isInCorso()) {
			model.addAttribute("erroreSessione", "Se la sessione non è in corso devi aggiungere una fine!");
			return "tempo/edit'";
			//devo mettere il banner di errore
		} 
		service.save(t);
		return "redirect:/gametime/tempi";			
	}
	
	@PostMapping("/gametime/tempi/update/{id}")
	public String edit(@PathVariable int idT, Model model) {
		TempoDiGioco t = service.getTempo(idT);
		//mi recupero gli utenti e videogiochi per visualizzare i nomi
		t.setUtente(serviceU.getUtente(t.getUtente().getId()));
		t.setVideogioco(serviceV.getVideogioco(t.getVideogioco().getId()));
		model.addAttribute("tempo", t);
		return "tempo/edit";
	}
	
}
