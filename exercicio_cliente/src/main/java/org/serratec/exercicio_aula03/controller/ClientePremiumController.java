package org.serratec.exercicio_aula03.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_aula03.domain.ClientePremium;
import org.serratec.exercicio_aula03.exception.RecursoNaoEncontradoException;
import org.serratec.exercicio_aula03.repository.ClientePremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientePremium")
public class ClientePremiumController {

    @Autowired
    private ClientePremiumRepository clientePremiumRepository;

    @GetMapping
    public List<ClientePremium> listarClientePremium() {
        return clientePremiumRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePremium> buscarPorId(@PathVariable Long id){
        ClientePremium clientePremium = clientePremiumRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Cliente Premium " + id + " não foi encontrado."));
        return ResponseEntity.ok(clientePremium);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientePremium adicionarClientePremium(@Valid @RequestBody ClientePremium clientePremium){
        return clientePremiumRepository.save(clientePremium);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePremium> atualizarClientePremium(@Valid @RequestBody ClientePremium clientePremium, @PathVariable Long id){
        if(!clientePremiumRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clientePremium.setId(id);
        clientePremium = clientePremiumRepository.save(clientePremium);
        return ResponseEntity.ok(clientePremium);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClientePremium(@PathVariable Long id){
        if (!clientePremiumRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clientePremiumRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
