package br.edu.ifsp.campus_match_spring.repository;

import br.edu.ifsp.campus_match_spring.model.Favorito;
import br.edu.ifsp.campus_match_spring.model.FavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoRepo extends JpaRepository<Favorito, FavoritoId> {}
