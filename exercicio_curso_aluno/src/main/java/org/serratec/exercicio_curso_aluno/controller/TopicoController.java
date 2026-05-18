package org.serratec.exercicio_curso_aluno.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_curso_aluno.domain.Curso;
import org.serratec.exercicio_curso_aluno.domain.Topico;
import org.serratec.exercicio_curso_aluno.repositories.CursoRepository;
import org.serratec.exercicio_curso_aluno.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopico(){
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public List<Topico> buscarPorId(@PathVariable Long id){
        Curso curso = cursoRepository.findById(id).orElseThrow();
        return curso.getTopicos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topico adicionarTopico (@Valid @RequestBody Topico topico) {
        return topicoRepository.save(topico);
    }
}
