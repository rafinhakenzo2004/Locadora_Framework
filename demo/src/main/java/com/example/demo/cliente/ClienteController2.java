package com.example.demo.cliente;
 
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
 
@Controller
@RequestMapping("/cliente")
public class ClienteController2 {
 
//    @Autowired
//    private EmailService emailService;
    @Autowired
    private ClienteService clienteService;
 
    @Autowired
// Listar todos os clientes
    @GetMapping
    public String listarTodos(Model model) {
    	List<Cliente> clientes = clienteService.listarTodos();
    	model.addAttribute ("listaClientes", clientes );
        return "cliente/listagem"; 
    }

    // Endpoint específico para validar CPF (útil para frontend)
//    @PostMapping("/validar-cpf")
//    public ResponseEntity<Map<String, Object>> validarCpf(@RequestBody Map<String, String> request) {
//        String cpf = request.get("cpf");
//        
//        boolean isValid = cpfValidator.isValid(cpf);
//        
//        return ResponseEntity.ok(Map.of(
//            "cpf", cpf,
//            "valido", isValid,
//            "formatado", isValid ? cpfValidator.formatar(cpf) : null,
//            "mensagem", isValid ? "CPF válido" : "CPF inválido"
//        ));
//    }
    // Buscar cliente por CPF
//    @GetMapping("/cpf/{cpf}")
//    public ResponseEntity<?> buscarPorCpf(@PathVariable String cpf) {
//        try {
//            return ResponseEntity.ok(new Cliente());
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest()
//                .body(Map.of("erro", e.getMessage()));
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(Map.of("erro", e.getMessage()));
//        }
//    }

}