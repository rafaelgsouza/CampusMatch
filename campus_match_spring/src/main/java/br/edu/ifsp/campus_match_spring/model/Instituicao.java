package br.edu.ifsp.campus_match_spring.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "instituicao")
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String senha;
    private String cep;
    private String nome;

    @Column(name = "numero_mec")
    private int numeroMec;
    private String campus;
    private boolean publica;

    @OneToMany
    @JoinTable(
        name = "instituicao_curso",
        joinColumns = @JoinColumn(name = "id_instituicao"),
        inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private List<Curso> cursos;

    @OneToMany
    @JoinTable(
        name = "instituicao_infraestrutura",
        joinColumns = @JoinColumn(name = "id_instituicao"),
        inverseJoinColumns = @JoinColumn(name = "id_infraestrutura")
    )
    private List<Infraestrutura> infraestruturas;

    @OneToMany
    @JoinTable(
        name = "instituicao_publicacao",
        joinColumns = @JoinColumn(name = "id_instituicao"),
        inverseJoinColumns = @JoinColumn(name = "id_publicacao")
    )
    private List<Publicacao> publicacoes;

    // Getters e setters para os campos e listas

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroMec() {
        return numeroMec;
    }

    public void setNumeroMec(int numeroMec) {
        this.numeroMec = numeroMec;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public boolean isPublica() {
        return publica;
    }

    public void setPublica(boolean publica) {
        this.publica = publica;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Infraestrutura> getInfraestruturas() {
        return infraestruturas;
    }

    public void setInfraestruturas(List<Infraestrutura> infraestruturas) {
        this.infraestruturas = infraestruturas;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
}
