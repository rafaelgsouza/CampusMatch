package br.edu.ifsp.campus_match_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifsp.campus_match_spring.model.InstituicaoCurso;
import br.edu.ifsp.campus_match_spring.repository.CursoRepo;
import br.edu.ifsp.campus_match_spring.repository.InstituicaoCursoRepo;
import br.edu.ifsp.campus_match_spring.repository.InstituicaoRepo;

@Controller
@RequestMapping("/instituicaoCurso")
public class InstituicaoCursoController {

    @Autowired
    private InstituicaoCursoRepo instituicaoCursoRepo;

    @Autowired
    private InstituicaoRepo instituicaoRepo;

    @Autowired
    private CursoRepo cursoRepo;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("instituicaoCursos", instituicaoCursoRepo.findAll());
        return "/pages/instituicaoCurso/InstituicaoCursoIndex";
    }

    @GetMapping("new")
    public String newInstituicaoCurso(Model model) {
        model.addAttribute("instituicoes", instituicaoRepo.findAll());
        model.addAttribute("cursos", cursoRepo.findAll());
        model.addAttribute("instituicaoCurso", new InstituicaoCurso());
        return "/pages/instituicaoCurso/InstituicaoCursoNew";
    }

    @PostMapping("save")
    public String saveInstituicaoCurso(@ModelAttribute InstituicaoCurso instituicaoCurso) {
        instituicaoCursoRepo.save(instituicaoCurso);
        return "redirect:/instituicaoCurso/index";
    }

    @GetMapping("delete/{id}")
    public String deleteInstituicaoCurso(@PathVariable Long id) {
        instituicaoCursoRepo.deleteById(id);
        return "redirect:/instituicaoCurso/index";
    }
}
