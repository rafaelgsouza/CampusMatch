package br.edu.ifsp.campus_match_spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.campus_match_spring.repository.EstudanteRepo;
import br.edu.ifsp.campus_match_spring.repository.InstituicaoRepo;

@Service
public class UserDetailsSecurityService implements UserDetailsService {
	
    private final EstudanteRepo estudanteRepo;
    private final InstituicaoRepo instituicaoRepo;
    
    public UserDetailsSecurityService(EstudanteRepo estudanteRepo, InstituicaoRepo instituicaoRepo) {
        this.estudanteRepo = estudanteRepo;
        this.instituicaoRepo = instituicaoRepo;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return estudanteRepo.getLoginByEmail(username);
		} catch (UsernameNotFoundException e) {
			try {
				return instituicaoRepo.getLoginByEmail(username);
			} catch (UsernameNotFoundException ee) {
				throw new UsernameNotFoundException("Não foi possível encontrar estudante/instituição na base de dados!.");
			}
		}
	
	}


}
