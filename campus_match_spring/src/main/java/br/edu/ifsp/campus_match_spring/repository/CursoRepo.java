package br.edu.ifsp.campus_match_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.campus_match_spring.model.Curso;

public interface CursoRepo extends JpaRepository<Curso, Long>{

}
