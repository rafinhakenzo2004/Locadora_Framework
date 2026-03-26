package com.example.demo.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
 
@Controller
@RequestMapping("/filme")
public class FilmeController {
 
	@Autowired
	private FilmeRepository filmeRepository;
 
	//listar todos os filmes
	@GetMapping                                           
	public String carregaPaginaListagem (Model model, HttpSession session){  
 
		model.addAttribute("lista", filmeRepository.findAll(Sort.by("titulo").ascending()));
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
	@GetMapping("/delete/{id}")
	@Transactional
	public String deleteTutorial(@PathVariable("id") Long id, Model model, HttpSession session,  RedirectAttributes redirectAttributes) {
		try {
			filmeRepository.deleteById(id);
			redirectAttributes.addFlashAttribute("message", "O filme " + id + " foi apagado!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/filme";
	}
	// Para editar filme com ID
			@GetMapping ("/formulario/{id}")                  
			public String carregaPaginaFormulario (@PathVariable("id") Long id,
					HttpSession session,
					RedirectAttributes redirectAttributes,
					Model model){
	 
				try {
					Filme filme = filmeRepository.findById(id)
							.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
					model.addAttribute("filme", filme);
					return "filme/formulario";
	 
				} catch (EntityNotFoundException e) {
					redirectAttributes.addFlashAttribute("error", e.getMessage());
					// Adicione as linhas para identificar o usuário
					
					return "redirect:/filme";
				}
			}  
}