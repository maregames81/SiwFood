package it.uniroma3.siw.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.RicettaRepository;

@Service
public class RicettaService {

	@Autowired
	private RicettaRepository ricettaRepository;
	
	public Ricetta findById(Long id) {
		return ricettaRepository.findById(id).get();
	}

	public Iterable<Ricetta> findAll() {
		return ricettaRepository.findAll();
	}

	public void save(Ricetta ricetta,MultipartFile file) throws IOException {
		ricetta.setFoto(Base64.getEncoder().encodeToString(file.getBytes()));
		ricettaRepository.save(ricetta);		
	}

}
