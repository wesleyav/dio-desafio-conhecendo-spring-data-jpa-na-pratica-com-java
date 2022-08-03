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

import com.github.wesleyav.academiadigital.entities.Matricula;
import com.github.wesleyav.academiadigital.services.MatriculaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(name = "/api/v1")
@Tag(name = "Matrícula")
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;

	@GetMapping(value = "/matriculas/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para listar matrículas")
	public List<Matricula> findAll() {
		List<Matricula> matriculas = matriculaService.findAll();
		return matriculas;
	}

	@GetMapping(value = "/matriculas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para listar matrículas por Id")
	public ResponseEntity<Matricula> findById(@PathVariable Long id) {
		Optional<Matricula> optMatriculas = matriculaService.findById(id);
		if (optMatriculas.isPresent()) {
			return ResponseEntity.ok(optMatriculas.get());
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping(value = "/matriculas/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para criar Matrícula")
	public ResponseEntity<Matricula> create(@Valid @RequestBody Matricula matricula) {
		Matricula obj = matriculaService.save(matricula);
		return new ResponseEntity<Matricula>(obj, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/matriculas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para deletar Matrícula")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Optional<Matricula> otpMatricula = matriculaService.findById(id);
		if (otpMatricula.isPresent()) {
			matriculaService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
