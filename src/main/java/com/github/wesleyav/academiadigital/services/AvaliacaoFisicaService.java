package com.github.wesleyav.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.wesleyav.academiadigital.entities.AvaliacaoFisica;
import com.github.wesleyav.academiadigital.repositories.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	public List<AvaliacaoFisica> findAll() {
		return avaliacaoFisicaRepository.findAll();
	}

	public Optional<AvaliacaoFisica> findById(Long id) {
		return Optional.ofNullable(avaliacaoFisicaRepository.findById(id).orElse(null));
	}

	public AvaliacaoFisica save(AvaliacaoFisica avaliacaoFisica) {
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	public void deleteById(@PathVariable Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}

}
