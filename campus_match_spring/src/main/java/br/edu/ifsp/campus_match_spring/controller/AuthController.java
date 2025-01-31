package br.edu.ifsp.campus_match_spring.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifsp.campus_match_spring.model.Estudante;
import br.edu.ifsp.campus_match_spring.model.Instituicao;
import br.edu.ifsp.campus_match_spring.model.LoginUser;
import br.edu.ifsp.campus_match_spring.model.UserRecoveryPassword;
import br.edu.ifsp.campus_match_spring.service.LoginService;
import br.edu.ifsp.campus_match_spring.util.Constants;


@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("landingPage")
	public String landingPage(Model model) {
		return "pages/web/landingPage";
	}
	
    @GetMapping("login")
    public String login(Model model) {
    	if(model.getAttribute("LoginUser") == null) {
        	model.addAttribute("LoginUser", new LoginUser());
    	}
    	
        return "/pages/auth/login";
    }
    
    @PostMapping("logUser")
	public String logUser(Model model, @ModelAttribute LoginUser loginUser) {
    	
    	Authentication auth = loginService.tryLogin(loginUser);
    	
    	if(!auth.isAuthenticated()) {
    		model.addAttribute("LoginUser", loginUser);
        	
        	return "/pages/auth/login";
    	}
    	
    	for(GrantedAuthority authority : auth.getAuthorities()) {
    		String role = authority.getAuthority();
    		
    	switch(role) {
    		case Constants.USER_ESTUDANTE:
    			return "redirect:/estudantes/home";
    		case Constants.USER_INSTITUICAO:
    			return "redirect:/instituicoes/home";
    		case Constants.STRING_FALSE:
    			break;
    		}
    	}
    	
    	return "/pages/auth/login";

	}
    
	@GetMapping("instituicao")
	public String registerInstituicaoGet(Model model) {
    	if(model.getAttribute("instituicao") == null) {
        	model.addAttribute("instituicao", new Instituicao());
    	}
		return "/pages/auth/instituicaoregistrar";
	}
	
    @GetMapping("estudante")
    public String registerEstudante(Model model) {
    	if(model.getAttribute("estudante") == null) {
        	model.addAttribute("estudante", new Estudante());
    	}
    	
        return "/pages/auth/estudanteregistrar";
    }
    
    @GetMapping("recuperarsenha")
    public String recoveryPassword(Model model) {
        return "/pages/auth/recuperarsenha";
    }
    
    @PostMapping("recoverypassword")
    public String recoveryPasswordSendemail(Model model, @ModelAttribute LoginUser loginUser){
		String current_url = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
    	loginService.recoveryPassword(loginUser.getEmail(), current_url);
    	model.addAttribute("email", loginUser.getEmail());
    	
    	return "/pages/auth/recuperarsenhamensagem";
    }
    
    @GetMapping("recoverypassword/{uuid}")
    public String recoveryPasswordSendemailFinal(@PathVariable("uuid") String uuid, Model model){

    	if(loginService.verifyRecoveryPasswordUrlRequest(uuid) == true) {
    		UserRecoveryPassword userRecoveryPassword = new UserRecoveryPassword();
    		userRecoveryPassword.setUuid(uuid);
    		model.addAttribute("userRecoveryPassword",userRecoveryPassword);
    		return "/pages/auth/recoverypasswordform";
    	} else {
        	return "redirect:/auth/login";
    	}
    }
    
    @PostMapping("recoverypasswordfinal")
    public String recoveryPasswordFinal(Model model, @ModelAttribute UserRecoveryPassword userRecoveryPassword){
    	if(loginService.recoveryPasswordForUuid(userRecoveryPassword.getUuid(), userRecoveryPassword.getPassword())) {
        	return "redirect:/auth/login";
    	};
    	
    	return "redirect:/auth/login";
    }
}
