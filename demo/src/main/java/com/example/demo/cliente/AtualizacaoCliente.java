package com.example.demo.cliente;


import jakarta.validation.constraints.NotBlank;

public record AtualizacaoCliente(
		  Long id,
		  @NotBlank(message = "Nome é obrigatório")
		  String nome,
		  @NotBlank(message = "Fone é obrigatório")
		  String fone,
		  @NotBlank(message = "Nome é obrigatório")
		  String email
		  ) {}
