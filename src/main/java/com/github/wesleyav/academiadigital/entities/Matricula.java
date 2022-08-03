package com.github.wesleyav.academiadigital.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matricula")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "O Id do aluno precisa ser positivo.")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	private LocalDateTime dataDaMatricula = LocalDateTime.now();

}
