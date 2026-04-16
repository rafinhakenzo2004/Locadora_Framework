package com.example.demo.cliente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
	public interface ClienteMapper {
		 // Converte Entity para DTO (para preencher formulário de edição)
	    AtualizacaoCliente toAtualizacaoDto(Cliente cliente);
	    
	    // Converte DTO para Entity (para criação NOVA - ignora ID)
	    @Mapping(target = "id", ignore = true)
	    Cliente toEntityFromAtualizacao(AtualizacaoCliente dto);
	    
	    // Atualiza Entity existente com dados do DTO
	    @Mapping(target = "id", ignore = true) // Não atualiza ID
	    void updateEntityFromDto(AtualizacaoCliente dto, @MappingTarget Cliente cliente);
	}