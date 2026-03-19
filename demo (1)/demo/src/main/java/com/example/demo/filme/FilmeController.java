package com.example.demo.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
 
@Controller
@RequestMapping("/filme")
public class FilmeController {
 
	@Autowired
	private FilmeRepository filmeRepository;
 
	//listar todos os filmes
	@GetMapping                                           
	public String carregaPaginaListagem (Model model, HttpSession session){  
 
		//model.addAttribute("lista", filmeRepository.findAll(Sort.by("titulo").ascending()));
		return "filme/listagem";                         
	}
 
	@GetMapping("/formulario")
	public String novoFilme(Model model,  HttpSession session) {
 
		model.addAttribute("filme", new Filme());
		return "filme/formulario";
	}
 
	// Método para gravar/atualizar o formulário
	@PostMapping("/salvar")
	public String salvarFilme( @ModelAttribute("filme") Filme filme,
			BindingResult result, HttpSession session,
			RedirectAttributes redirectAttributes) {
		// Adicione as linhas para identificar o usuário
		// Validação de erros
		if (result.hasErrors()) {
			return "filme/formulario";
		}
		try {
			filmeRepository.save(filme);
			String mensagem = filme.getId() != null ?
					"Filme '" + filme.getTitulo() + "' atualizado com sucesso!" :
						"Filme '" + filme.getTitulo() + "' criado com sucesso!";
			redirectAttributes.addFlashAttribute("message", mensagem);
			return "redirect:/filme";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Erro ao salvar filme: " + e.getMessage());
			return "redirect:/filme/formulario" + (filme.getId() != null ? "/" + filme.getId() : "");
		}
	}
}