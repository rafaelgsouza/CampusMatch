package br.edu.ifsp.campus_match_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.campus_match_spring.model.Estudante;
import br.edu.ifsp.campus_match_spring.repository.EstudanteRepo;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	private EstudanteRepo estudanteRepo;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		List<Estudante> estudantes = estudanteRepo.findAll();
		
		model.addAttribute("estudantes", estudantes);
		
		return "/pages/estudante/EstudanteIndex";
	}
	
	@RequestMapping("get_all")
	public ResponseEntity<List<Estudante>> getAllStudents(){
		
		List<Estudante> estudantes = estudanteRepo.findAll();
		
		return new ResponseEntity<>(estudantes, HttpStatus.OK);
		
	}
	
	@RequestMapping("new")
	public String newEstudante(Model model) {
		
		model.addAttribute("estudante", new Estudante());
		
		return "/pages/estudante/EstudanteNew";
	}
	
	@PostMapping("save")
	public ResponseEntity<String> saveEstudante(@ModelAttribute Estudante estudante) {
		
		estudanteRepo.save(estudante);
		
		return new ResponseEntity<>("Estudante salvo", HttpStatus.OK);
	}
	
	@RequestMapping("editEstudante/{id}")
	public String editEstudante(@PathVariable("id") Estudante estudante, Model model) {
		
		model.addAttribute(estudante);
		
		return "/pages/estudante/EstudanteNew";
	}
	
	@RequestMapping("deleteEstudante/{id}")
	public String deleteEstudante(@PathVariable("id") Long id) {
		
		estudanteRepo.deleteById(id);
		
		return "redirect:/estudantes/index";
	}
}
