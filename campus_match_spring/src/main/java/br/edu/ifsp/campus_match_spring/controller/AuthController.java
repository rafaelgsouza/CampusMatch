package br.edu.ifsp.campus_match_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.campus_match_spring.model.LoginUser;
import br.edu.ifsp.campus_match_spring.service.LoginService;


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
    	model.addAttribute("LoginUser", new LoginUser());
    	
        return "/pages/web/login";
    }
    
    @RequestMapping("logUser")
	public String logUser(Model model, @ModelAttribute LoginUser loginUser) {
		
    	if(loginService.tryLogin(loginUser)) {
    		return "redirect:home";
    	}
    	
    	model.addAttribute("LoginUser", loginUser);
    	
    	return "/pages/web/login";
    	
	}
    
    @RequestMapping("home")
	public String home(Model model) {
		
    	
    	
    	return "pages/web/home";
    	
	}
    
	@GetMapping("instituicao")
	public String registerInstituicaoGet(Model model) {
		return "/pages/web/instituicaoregistrar";
	}
	
    @GetMapping("estudante")
    public String registerEstudante(Model model) {
        return "/pages/web/estudanteregistrar";
    }
}
