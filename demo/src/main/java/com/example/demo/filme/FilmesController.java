package com.example.demo.filme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RequestMapping("/filmes")
@RestController
@CrossOrigin
public class FilmesController {

		
		@Autowired
		private FilmeService filmeService;
		
		@GetMapping("/public/lista")
		public List<Filme> Listagem() {
			return filmeService.getAllFilme();
		}
		
		//com segurança
		@PostMapping
		@Transactional
		public ResponseEntity<?> cadastrar(
				@RequestHeader("X-API-KEY") String apiKey,
				@RequestBody @Valid DadosCadastroFilme dados) {
			//solução com alto acoplamento, pois o controller tem que saber muita coisa
			//viola 3 principios do SOLID SRP, DIP, OCP
			//ideal eh desmembrar o teste para outra classe
			
			//validar chave que veio do frontend
			
//			if (!CHAVES_VALIDAS.contains(apiKey)) {
//				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//						.body("{\"erro\":\"Chave API inválida\"}");
//			}
			//crei um método para validar a chave
//			if (!isValidApiKey(apiKey)) {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//	            		.body("{\"erro\":\"Chave API inválida\"}");
//	        }
			
			filmeService.salvar(dados);
			//controller sabe muito sobre validacao
			return ResponseEntity.status(HttpStatus.CREATED).body(dados);
		}
		
//		private final Set<String> CHAVES_VALIDAS = Set.of(
//		"cco123",
//		"azul123"
//);
		
}	
