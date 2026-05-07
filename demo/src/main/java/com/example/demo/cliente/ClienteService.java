package com.example.demo.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepositoy2 repository;

    public Cliente createCliente(Cliente cliente){
        repository.save(cliente);
        return cliente;
    }

	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
