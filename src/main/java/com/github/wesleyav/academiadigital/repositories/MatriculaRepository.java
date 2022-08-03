package com.github.wesleyav.academiadigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.wesleyav.academiadigital.entities.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
