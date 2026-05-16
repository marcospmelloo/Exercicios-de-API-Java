package org.serratec.exercicio_curso_aluno.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_curso_aluno.domain.Aluno;
import org.serratec.exercicio_curso_aluno.domain.Curso;
import org.serratec.exercicio_curso_aluno.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos(){
        List<Curso> cursos = cursoRepository.findAll();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id){
        Optional<Curso> cursos = cursoRepository.findById(id);
        if(cursos.isPresent()){
            return ResponseEntity.ok(cursos.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso adicionarCurso (@Valid @RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }
}
