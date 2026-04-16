package com.example.demo.cliente;

import com.example.validarCPF.annotation.ValidCpf;

import jakarta.validation.constraints.NotBlank;

public record AtualizacaoCliente(
		  Long id,
		  @NotBlank(message = "Nome é obrigatório")
		  String nome,
		  @NotBlank(message = "Fone é obrigatório")
		  String fone,
		  @ValidCpf(message = "CPF inválido")  // meu componente
		  String cpf,
		  @NotBlank(message = "Nome é obrigatório")
		  String email
		  ) {}
