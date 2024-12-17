package br.edu.ifsp.campus_match_spring.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long nota;
	
	private String comentario;
	
	@Column(name = "data_avaliacao")
	private Date dataAvaliacao;
	
	@ManyToMany(targetEntity = Instituicao.class)
	@JoinTable(
			name = "favorito",
			joinColumns = @JoinColumn(name = "?"),
			inverseJoinColumns = @JoinColumn(name = "?")
			)
	private Long idInstituicao;
	
	private Long idEstudante;
	
}
