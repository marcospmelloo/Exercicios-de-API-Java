package org.serratec.exercicio_editora.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_editora.domain.Avaliacao;
import org.serratec.exercicio_editora.domain.Editora;
import org.serratec.exercicio_editora.repositories.AvaliacaoRepository;
import org.serratec.exercicio_editora.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes(){
        List<Avaliacao> avaliacao = avaliacaoRepository.findAll();
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
        if(avaliacao.isPresent()){
            return ResponseEntity.ok(avaliacao.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avaliacao adicionarAvaliacao (@Valid @RequestBody Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }
}
