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

import br.edu.ifsp.campus_match_spring.model.Infraestrutura;
import br.edu.ifsp.campus_match_spring.repository.InfraestruturaRepo;

@Controller
@RequestMapping("/infraestruturas")
public class InfraestruturaController {
	
	@Autowired
	private InfraestruturaRepo InfraestruturaRepo; 
	
	@GetMapping("index")
	public String index(Model model) {
		
		List<Infraestrutura> infraestruturas = InfraestruturaRepo.findAll();
		
		model.addAttribute("infraestruturas", infraestruturas);
		
		return "/pages/infraestrutura/InfraestruturaIndex";
	}
	
	@GetMapping("new")
	public String newInfraestrutura(Model model) {
		
		model.addAttribute("infraestrutura", new Infraestrutura());
		
		return "/pages/infraestrutura/InfraestruturaNew";
	}
	
	@PostMapping("save")
	public String saveInfraestrutura(@ModelAttribute Infraestrutura infraestrutura) {
		
		InfraestruturaRepo.save(infraestrutura);
		
		return "redirect:index";
	}
	
	@GetMapping("editInfraestrutura/{id}")
	public String editInfraestrutura(@PathVariable("id") Infraestrutura infraestrutura, Model model) {
		
		model.addAttribute(infraestrutura);
		
		return "/pages/infraestrutura/InfraestruturaNew";
	}
	

	@GetMapping("deleteInfraestrutura/{id}")
	public String deleteInfraestrutura(@PathVariable Long id) {
		
		InfraestruturaRepo.deleteById(id);
		
		return "redirect:/infraestruturas/index";
	}
}
