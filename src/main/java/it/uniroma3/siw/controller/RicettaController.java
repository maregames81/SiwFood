package it.uniroma3.siw.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.IngredienteService;
import it.uniroma3.siw.service.RicettaService;

@Controller 
public class RicettaController {

	@Autowired RicettaService ricettaService;
	
	@Autowired IngredienteService ingredienteService;
	
	@Autowired CredentialsService credentialsService;
	
	
	@GetMapping("/ricette")
	public String showRicette (Model model) {
		model.addAttribute("ricette", this.ricettaService.findAll());
		return "ricette.html";
	}
	
	@GetMapping("/newRicetta")
	public String newRicetta(Model model) {
		model.addAttribute("ricetta", new Ricetta());
		
		return "newRicetta.html";
	}
	
	@PostMapping(value = { "/newRicetta" })
	public String newRicetta(@ModelAttribute("ricetta") Ricetta ricetta,
			@ModelAttribute("userDetails") UserDetails userD,@RequestParam("imageFile") MultipartFile imageFile,
			@ModelAttribute("descrizione") String desc, Model model) throws IOException {
		String username = userD.getUsername();
		Cuoco c= credentialsService.getCredentials(username).getUser().getCuoco();
		
		
		ricetta.setCuoco(c);
		ricetta.setDescrizione(desc);
		ricettaService.save(ricetta, imageFile);
		model.addAttribute("ingredienti", this.ingredienteService.findAll());
		return"aggiungiIngrediente.html";
	}
}
