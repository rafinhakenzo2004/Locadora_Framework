package com.example.demo.filme;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
 
 
@Service
public class FilmeService {
	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<Filme> getAllFilme() {
		return filmeRepository.findAll(Sort.by("titulo").ascending());
	}
	public Filme getFilmeById(Long id) {
		return filmeRepository.getReferenceById(id);
	}
	public List<Filme> findAllById(List<Long> filmesIds) {
		return filmeRepository.findAllById(filmesIds);
	}
	public void salvar(@Valid DadosCadastroFilme dados) {
		// TODO Auto-generated method stub
		
	}
 
/*	public List<Filme> buscarLancamentosDoAno() {
        int anoAtual = Year.now().getValue();
        return filmeRepository.findByDataLancamento(anoAtual);
    }
	
	public List<Filme> buscarFilmesDestaque() {
        // Implementar lógica específica para filmes em destaque
        // Exemplo: 5 filmes mais recentes ou mais avaliados
        return filmeRepository.findTop5ByOrderByDataLancamentoDesc();
    }*/
}