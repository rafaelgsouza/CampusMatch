package br.edu.ifsp.campus_match_spring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public String saveEstudante(@ModelAttribute Estudante estudante, Model model) {
		
		estudante.setUuid(UUID.randomUUID().toString());
		estudante.setValidado(0);
		
		model.addAttribute(estudante);
		Estudante e = estudanteRepo.getByEmail(estudante.getEmail());
		
		// TODO: Implement error handling for all fields.
		// https://www.youtube.com/watch?v=dUoCQ1s3Dcs
		if(e != null) {
			return "/pages/web/estudanteregistrar";
		}
		
		estudanteRepo.save(estudante);
		return "/pages/web/estudanteconfirmacao";
	}
	
	@RequestMapping("editEstudante/{id}")
	public String editEstudante(@PathVariable("id") Estudante estudante, Model model) {
		
		model.addAttribute(estudante);
		
		return "/pages/web/EstudanteNew";
	}
	
	@RequestMapping("deleteEstudante/{id}")
	public String deleteEstudante(@PathVariable("id") Long id) {
		
		estudanteRepo.deleteById(id);
		
		return "redirect:/estudantes/index";
	}
}
