package org.serratec.exercicio_aula03.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_aula03.domain.ClienteVip;
import org.serratec.exercicio_aula03.exception.RecursoNaoEncontradoException;
import org.serratec.exercicio_aula03.repository.ClienteVipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientesVip")
public class ClienteVipController {

    @Autowired
    private ClienteVipRepository clienteVipRepository;

    @GetMapping
    public List<ClienteVip> listarClienteVip() {
        return clienteVipRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteVip> buscarPorId(@PathVariable Long id){
        ClienteVip clienteVip = clienteVipRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Cliente Vip " + id + " não foi encontrado."));
        return ResponseEntity.ok(clienteVip);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteVip adicionarClienteVip(@Valid @RequestBody ClienteVip clienteVip){
        return clienteVipRepository.save(clienteVip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteVip> atualizarClienteVip(@Valid @RequestBody ClienteVip clienteVip, @PathVariable Long id){
        if(!clienteVipRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteVip.setId(id);
        clienteVip = clienteVipRepository.save(clienteVip);
        return ResponseEntity.ok(clienteVip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClienteVip(@PathVariable Long id){
        if (!clienteVipRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clienteVipRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
