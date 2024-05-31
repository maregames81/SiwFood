package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.CuocoService;

@Controller
public class CuocoController {

	@Autowired CuocoService cuocoService;
	
	
	@GetMapping("/cuochi")
	public String listaCuochi(Model model) {
		model.addAttribute("cuochi", this.cuocoService.findAll());
		return "cuochi.html";
	}
	
	
	
	
}
