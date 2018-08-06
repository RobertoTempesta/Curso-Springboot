package com.roberto.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roberto.brewer.model.Estilo;
import com.roberto.brewer.repository.Estilos;
import com.roberto.brewer.service.exception.NomeEstiloJaCadastradoException;

@Service
public class CadastroEstilosService {

	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo) {
		Optional<Estilo> optionalEstilo = estilos.findByNomeIgnoreCase(estilo.getNome());
		if(optionalEstilo.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome já cadastrado!");
		}
		return estilos.saveAndFlush(estilo);
	}
}
