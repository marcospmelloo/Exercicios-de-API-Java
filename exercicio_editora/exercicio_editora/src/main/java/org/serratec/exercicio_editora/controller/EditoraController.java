package org.serratec.exercicio_editora.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_editora.domain.Editora;
import org.serratec.exercicio_editora.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras(){
        List<Editora> editoras = editoraRepository.findAll();
        return ResponseEntity.ok(editoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarPorId(@PathVariable Long id){
        Optional<Editora> editora = editoraRepository.findById(id);
        if(editora.isPresent()){
            return ResponseEntity.ok(editora.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Editora adicionarEditora (@Valid @RequestBody Editora editora) {
        return editoraRepository.save(editora);
    }
}
