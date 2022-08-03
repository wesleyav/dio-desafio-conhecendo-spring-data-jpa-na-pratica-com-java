package com.github.wesleyav.academiadigital.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.academiadigital.entities.Aluno;
import com.github.wesleyav.academiadigital.services.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(name = "/api/v1")
@Tag(name = "Aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping(value = "/alunos/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para listar alunos")
	public List<Aluno> findAll() {
		List<Aluno> alunos = alunoService.findAll();
		return alunos;
	}

	@GetMapping(value = "/alunos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para listar alunos por Id")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Optional<Aluno> optAluno = alunoService.findById(id);
		if (optAluno.isPresent()) {
			return ResponseEntity.ok(optAluno.get());
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping(value = "/alunos/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para criar Aluno")
	public ResponseEntity<Aluno> create(@Valid @RequestBody Aluno aluno) {
		Aluno obj = alunoService.save(aluno);
		return new ResponseEntity<Aluno>(obj, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/alunos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para deletar Aluno")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Optional<Aluno> optAluno = alunoService.findById(id);
		if (optAluno.isPresent()) {
			alunoService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
