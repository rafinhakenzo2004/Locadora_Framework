package com.example.demo.cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    ClienteService service;
    
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/criarcliente")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        service.createCliente(cliente);
        return ResponseEntity.ok(cliente);
    }
    
}
