package br.edu.ifsp.campus_match_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifsp.campus_match_spring.model.Instituicao;
import br.edu.ifsp.campus_match_spring.repository.InstituicaoRepo;
import br.edu.ifsp.campus_match_spring.service.InstituicaoService;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoRepo instituicaoRepo;
	
	@Autowired
	private InstituicaoService instituicaoService;
		
	@GetMapping("index")
	public String index(Model model) {
		
		List<Instituicao> instituicoes = instituicaoRepo.findAll();
		
		model.addAttribute("instituicoes", instituicoes);
		
		return "/pages/instituicao/InstituicaoIndex";
	}
	
	@PostMapping("new")
	public String newInstituicao(Model model) {
		
		model.addAttribute("instituicao", new Instituicao());
		
		return "/pages/instituicao/InstituicaoNew";
	}
	
	@PostMapping("save")
	public String saveInstituicao(@ModelAttribute Instituicao instituicao, Model model, RedirectAttributes redirectAttrs) {
		
		model.addAttribute("instituicao",instituicao);
		redirectAttrs.addFlashAttribute("instituicao",instituicao);
		String current_url = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
		
		if( instituicaoService.register(instituicao,current_url)) {
			return "/pages/auth/instituicaoconfirmacao";

		}else {
			return "redirect:/auth/instituicao";

		}
	}
	
	@GetMapping("save/{uuid}")
	public String validateInstituicao(@PathVariable("uuid") String uuid, Model model) {
				
		if(instituicaoService.validate(uuid)) {
			return "redirect:/auth/login";
		} else {
			return "redirect:/auth/login";
		}

	}
	
	@PostMapping("editInstituicao/{id}")
	public String editInstituicao(@PathVariable("id") Long id, Model model) {
	    Instituicao instituicao = instituicaoRepo.findById(id).orElse(null);
	    model.addAttribute("instituicao", instituicao);
	    return "/pages/instituicao/InstituicaoNew";
	}

	
	@GetMapping("deleteInstituicao/{id}")
	public String deleteInstituicao(@PathVariable("id") Long id) {
		
		instituicaoRepo.deleteById(id);
		
		return "redirect:/instituicoes/index";
	}
	
}
