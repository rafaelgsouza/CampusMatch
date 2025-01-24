package br.edu.ifsp.campus_match_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.campus_match_spring.model.Estudante;
import br.edu.ifsp.campus_match_spring.model.Instituicao;
import br.edu.ifsp.campus_match_spring.model.LoginUser;
import br.edu.ifsp.campus_match_spring.repository.EstudanteRepo;
import br.edu.ifsp.campus_match_spring.repository.InstituicaoRepo;

@Service
public class LoginService {

    private final EstudanteRepo estudanteRepo;
    private final InstituicaoRepo instituicaoRepo;
    
    @Autowired
    public LoginService(EstudanteRepo estudanteRepo, InstituicaoRepo instituicaoRepo) {
        this.estudanteRepo = estudanteRepo;
        this.instituicaoRepo = instituicaoRepo;
    }
	
	public boolean tryLogin(LoginUser user) {
		
		Estudante estudante = estudanteRepo.getByEmail(user.getEmail());
		Instituicao instituicao = instituicaoRepo.getByEmail(user.getEmail());
		
		if(estudante != null) {
			if(user.getPassword().equals(estudante.getSenha())) {
				return true;
			}
		}
		else if(instituicao != null) {
			if(user.getPassword().equals(instituicao.getSenha())) {
				return true;
			}
		} else {
			return false;
		}
		
		return false;
		
	}
}
