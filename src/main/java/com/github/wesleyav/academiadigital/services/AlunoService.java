package com.github.wesleyav.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.wesleyav.academiadigital.entities.Aluno;
import com.github.wesleyav.academiadigital.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Optional<Aluno> findById(Long id) {
		return Optional.ofNullable(alunoRepository.findById(id).orElse(null));
	}

	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public void deleteById(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}
	


}
