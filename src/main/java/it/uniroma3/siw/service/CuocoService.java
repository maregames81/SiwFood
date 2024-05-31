package it.uniroma3.siw.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.repository.CuocoRepository;

@Service
public class CuocoService {
	
	@Autowired
	private CuocoRepository cuocoRepository;
	
	public Cuoco findById(Long id) {
		return cuocoRepository.findById(id).get();
	}

	public Iterable<Cuoco> findAll() {
		return cuocoRepository.findAll();
	}

	public void save(Cuoco cuoco,MultipartFile file) throws IOException {
		cuoco.setImmagine(Base64.getEncoder().encodeToString(file.getBytes()));
		cuocoRepository.save(cuoco);		
	}

}