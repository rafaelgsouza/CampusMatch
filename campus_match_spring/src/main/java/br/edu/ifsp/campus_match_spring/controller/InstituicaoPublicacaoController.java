package br.edu.ifsp.campus_match_spring.controller;

import br.edu.ifsp.campus_match_spring.model.InstituicaoPublicacao;
import br.edu.ifsp.campus_match_spring.repository.InstituicaoPublicacaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instituicaoPublicacao")
public class InstituicaoPublicacaoController {

    @Autowired
    private InstituicaoPublicacaoRepo instituicaoPublicacaoRepo;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("relacionamentos", instituicaoPublicacaoRepo.findAll());
        return "/pages/instituicaoPublicacao/InstituicaoPublicacaoIndex";
    }

    @GetMapping("new")
    public String newRelacionamento(Model model) {
        model.addAttribute("instituicaoPublicacao", new InstituicaoPublicacao());
        return "/pages/instituicaoPublicacao/InstituicaoPublicacaoNew";
    }

    @PostMapping("save")
    public String saveRelacionamento(@ModelAttribute InstituicaoPublicacao instituicaoPublicacao) {
        instituicaoPublicacaoRepo.save(instituicaoPublicacao);
        return "redirect:index";
    }

    @GetMapping("delete/{idInstituicao}/{idPublicacao}")
    public String deleteRelacionamento(@PathVariable Long id) {
        instituicaoPublicacaoRepo.deleteById(id);
        return "redirect:/instituicaoPublicacao/index";
    }
}