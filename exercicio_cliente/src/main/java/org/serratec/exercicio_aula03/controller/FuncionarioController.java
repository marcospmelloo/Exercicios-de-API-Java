package org.serratec.exercicio_aula03.controller;

import jakarta.validation.Valid;
import org.serratec.exercicio_aula03.domain.Funcionario;
import org.serratec.exercicio_aula03.exception.RecursoNaoEncontradoException;
import org.serratec.exercicio_aula03.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id){
        Funcionario func = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Funcionário " + id + " não foi encontrado."));
        return ResponseEntity.ok(func);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario adicionarFuncionario(@Valid @RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id){
        if(!funcionarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(id);
        funcionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id){
        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        funcionarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
