package org.serratec.exercicio_curso_aluno.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_curso_aluno.domain.Aluno;
import org.serratec.exercicio_curso_aluno.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
        Optional<Aluno> alunos = alunoRepository.findById(id);
        if(alunos.isPresent()){
            return ResponseEntity.ok(alunos.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno adicionarAluno (@Valid @RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

}
