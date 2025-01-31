package br.edu.ifsp.campus_match_spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.campus_match_spring.model.AreaConhecimento;
import br.edu.ifsp.campus_match_spring.model.Curso;
import br.edu.ifsp.campus_match_spring.model.Modalidade;
import br.edu.ifsp.campus_match_spring.model.Periodo;
import br.edu.ifsp.campus_match_spring.repository.CursoRepo;

@Controller
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepo cursoRepo; 
	
	@GetMapping("index")
	public String index(Model model) {
		
		List<Curso> cursos = cursoRepo.findAll();
		
		model.addAttribute("cursos", cursos);
		
		return "/pages/curso/CursoIndex";
	}
	
	@GetMapping("new")
	public String newCurso(Model model) {
		
		model.addAttribute("curso", new Curso());
		
		return "/pages/curso/CursoNew";
	}
	
	@PostMapping("save")
	public String saveCurso(@ModelAttribute Curso curso) {
		
		cursoRepo.save(curso);
		
		return "redirect:index";
	}
	
	@GetMapping("editCurso/{id}")
	public String editCurso(@PathVariable("id") Curso curso, Model model) {
		
		model.addAttribute(curso);
		
		return "/pages/curso/CursoNew";
	}
	
	@GetMapping("deleteCurso/{id}")
	public String deleteCurso(@PathVariable Long id) {
		
		cursoRepo.deleteById(id);
		
		return "redirect:/cursos/index";
	}
	
	@ModelAttribute("allPeriodos")
	public List<Periodo> allPeriodos(){
		return Arrays.asList(Periodo.values());
	}
	
	@ModelAttribute("allModalidades")
	public List<Modalidade> allModalidades(){
		return Arrays.asList(Modalidade.values());
	}
	
	@ModelAttribute("allAreasConhecimento")
	public List<AreaConhecimento> allAreasConhecimento(){
		return Arrays.asList(AreaConhecimento.values());
	}
	
}
