package com.example.demo.filme;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity 
@Table(name = "filme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Filme implements Serializable{
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String ano;
	private String classificacao;
	private LocalDate dataLancamento;
	private String duracao;
	private String genero;
	private String nomeDiretor;
	private String resumo;
	private String pais;
	private String lingua;
	private String poster;
	private boolean desabilitado;
	private String imdbId;
	@Transient //  não persiste no banco
	private String dataFormatada;
	public String getDataFormatada() {
		if (this.dataLancamento != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    this.dataFormatada = this.dataLancamento.format(formatter);
                }
                return this.dataFormatada;
	}
}