package com.github.wesleyav.academiadigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.wesleyav.academiadigital.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
