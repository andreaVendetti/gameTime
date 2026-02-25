package it.home.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.home.models.Videogioco;
import it.home.services.VideogiocoService;

@Controller
public class VideogameController {
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
	private VideogiocoService service;
	
	@GetMapping("/gametime/videogiochi")
	public String list(Model model) {
		model.addAttribute("videogames", service.getAll());
		return "videogioco/lista";
	}
	
	@GetMapping("/gametime/videogiochi/insert")
	public String edit(Model model) {
		model.addAttribute("videogioco", new Videogioco());
		return "videogioco/edit";
	}
	
	@PostMapping("/gametime/videogiochi/save")
	public ModelAndView edit(@ModelAttribute Videogioco videogioco) {
		service.save(videogioco);
		return new ModelAndView("redirect:/gametime/videogiochi");
	}
	
	@GetMapping("/gametime/videogiochi/update/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("videogioco", service.getVideogioco(id));
		return "videogioco/edit";
	}
	
	@GetMapping("/gametime/videogiochi/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		model.addAttribute("videogioco", service.getVideogioco(id));
		return "videogioco/delete";
	}
	
	@PostMapping("/gametime/videogiochi/delete")
	public ModelAndView delete(@ModelAttribute Videogioco videogioco) {
		service.delete(videogioco.getId());
		return new ModelAndView("redirect:/gametime/videogiochi");
	}
}
