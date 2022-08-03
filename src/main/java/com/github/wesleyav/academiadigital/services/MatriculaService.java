package com.github.wesleyav.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.wesleyav.academiadigital.entities.Matricula;
import com.github.wesleyav.academiadigital.repositories.MatriculaRepository;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	public Optional<Matricula> findById(Long id) {
		return Optional.ofNullable(matriculaRepository.findById(id).orElse(null));
	}

	public Matricula save(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}

	public void deleteById(@PathVariable Long id) {
		matriculaRepository.deleteById(id);
	}

}
