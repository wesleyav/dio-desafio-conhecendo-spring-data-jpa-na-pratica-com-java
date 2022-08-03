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

import com.github.wesleyav.academiadigital.entities.AvaliacaoFisica;
import com.github.wesleyav.academiadigital.services.AvaliacaoFisicaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(name = "/api/v1")
@Tag(name = "Avaliação Física")
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;

	@GetMapping(value = "/avaliacoes/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para listar Avaliações")
	public List<AvaliacaoFisica> findAll() {
		List<AvaliacaoFisica> alunos = avaliacaoFisicaService.findAll();
		return alunos;
	}

	@GetMapping(value = "/avaliacoes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para listar avaliações por Id")
	public ResponseEntity<AvaliacaoFisica> findById(@PathVariable Long id) {
		Optional<AvaliacaoFisica> optAvaliacaoFisica = avaliacaoFisicaService.findById(id);
		if (optAvaliacaoFisica.isPresent()) {
			return ResponseEntity.ok(optAvaliacaoFisica.get());
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping(value = "/avaliacoes/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para criar Avaliação")
	public ResponseEntity<AvaliacaoFisica> create(@Valid @RequestBody AvaliacaoFisica avaliacaoFisica) {
		AvaliacaoFisica obj = avaliacaoFisicaService.save(avaliacaoFisica);
		return new ResponseEntity<AvaliacaoFisica>(obj, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/avaliacoes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint para deletar avaliação")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Optional<AvaliacaoFisica> optAvaliacaoFisica = avaliacaoFisicaService.findById(id);
		if (optAvaliacaoFisica.isPresent()) {
			avaliacaoFisicaService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
