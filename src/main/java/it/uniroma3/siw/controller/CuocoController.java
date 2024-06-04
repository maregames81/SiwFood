package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.service.CuocoService;
import it.uniroma3.siw.service.RicettaService;

@Controller
public class CuocoController {

	@Autowired CuocoService cuocoService;
	
	@Autowired RicettaService Service;
	
	
	@GetMapping("/cuochi")
	public String listaCuochi(Model model) {
		model.addAttribute("cuochi", this.cuocoService.findAll());
		return "cuochi.html";
	}
	
	@GetMapping("/cuochi/{id}")
	public String cuoco(@PathVariable("id") Long id, Model model){
		
		Cuoco c= this.cuocoService.findById(id);
		
		model.addAttribute("cuoco", c);
		model.addAttribute("ricette", c.getRicette());
		
		return "cuoco.html";
	}
	
	
	
	
}
