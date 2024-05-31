package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.service.IngredienteService;
import jakarta.validation.Valid;

@Controller
public class IngredienteController {
	@Autowired IngredienteService ingredienteService;
	
	
	@GetMapping("/newIngrediente")
	public String newIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "newIngrediente.html";
	}
	
	@PostMapping("/newIngrediente")
	public String newIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente, Model model) {
		
		this.ingredienteService.save(ingrediente);
		model.addAttribute("ingredienti", this.ingredienteService.findAll());
		return "newRicetta.html";
	}
	
	

}
