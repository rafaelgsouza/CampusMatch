package br.edu.ifsp.campus_match_spring.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.edu.ifsp.campus_match_spring.model.Estudante;
import br.edu.ifsp.campus_match_spring.model.Instituicao;
import br.edu.ifsp.campus_match_spring.model.LoginUser;
import br.edu.ifsp.campus_match_spring.repository.EstudanteRepo;
import br.edu.ifsp.campus_match_spring.repository.InstituicaoRepo;

@Service
public class LoginService {
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MailService mailService;
		
    private final EstudanteRepo estudanteRepo;
    private final InstituicaoRepo instituicaoRepo;
    
    public LoginService(EstudanteRepo estudanteRepo, InstituicaoRepo instituicaoRepo) {
        this.estudanteRepo = estudanteRepo;
        this.instituicaoRepo = instituicaoRepo;
    }
	  
	
	public Authentication tryLogin(LoginUser user) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		return authenticationManager.authenticate(usernamePassword);
	}
    
	
	public boolean recoveryPassword(String email, String current_url) {
		Estudante estudante = estudanteRepo.getByEmail(email);
		Instituicao instituicao = instituicaoRepo.getByEmail(email);
		
		if(estudante != null) {
			estudante.setUuid(UUID.randomUUID().toString());
			estudanteRepo.save(estudante);
			mailService.sendMail(estudante.getEmail()
					, "Requisição de recuperação de senha (CampusMatch)"
					, "Segue link para recuperar sua senha:" + current_url + "/" + estudante.getUuid()
			);
			return true;
		} else {
			if(instituicao != null) {
				instituicao.setUuid(UUID.randomUUID().toString());
				instituicaoRepo.save(instituicao);
				mailService.sendMail(instituicao.getEmail()
						, "Requisição de recuperação de senha (CampusMatch)"
						, "Segue link para recuperar sua senha:" + current_url + "/" + instituicao.getUuid()
				);
				return true;
			} else {
				return false;
			}
		} 
	}
	
	public boolean recoveryPasswordForUuid(String uuid, String password) {
		Estudante estudante = estudanteRepo.getByUuid(uuid);
		Instituicao instituicao = instituicaoRepo.getByUuid(uuid);
		
		if(estudante != null) {
			estudante.setSenha(passwordService.hashPassword(password));
			estudante.setUuid(UUID.randomUUID().toString());
			estudanteRepo.save(estudante);
			mailService.sendMail(estudante.getEmail()
					, "Senha alterada (CampusMatch)"
					, "Sua senha de estudante no CampusMatch foi alterada"
			);
			return true;
		}else {
			if(instituicao != null) {
				instituicao.setSenha(passwordService.hashPassword(password));
				instituicao.setUuid(UUID.randomUUID().toString());
				instituicaoRepo.save(instituicao);
				mailService.sendMail(instituicao.getEmail()
						, "Senha alterada (CampusMatch)"
						, "Sua senha de instituição no CampusMatch foi alterada"
				);
				return true;
			}else {
				return false;
			}
		}
		
	}
	
	public boolean verifyRecoveryPasswordUrlRequest(String uuid) {
		Estudante estudante = estudanteRepo.getByUuid(uuid);
		Instituicao instituicao = instituicaoRepo.getByUuid(uuid);
		
		if(estudante != null) {
			return true;
		}else {
			if(instituicao != null) {
				return true;
			}else {
				return false;
			}
		}
		
	}


}
